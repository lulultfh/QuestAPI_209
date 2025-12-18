package com.example.prak8_209.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.prak8_209.model.DataSiswa
import com.example.prak8_209.repository.RepositoryDataSiswa
import kotlinx.coroutines.launch
import okio.IOException

sealed interface StatusUiSiswa{
    data class Success(val siswa: List<DataSiswa> = listOf()): StatusUiSiswa
    object Error: StatusUiSiswa
    object Loading: StatusUiSiswa
}
class HomeViewModel (private val repositoryDataSiswa: RepositoryDataSiswa):
ViewModel(){
    var listSiswa: StatusUiSiswa by mutableStateOf(StatusUiSiswa.Loading)
        private set
    init {
        loadSiswa()
    }
    fun loadSiswa(){
        viewModelScope.launch {
            listSiswa = StatusUiSiswa.Loading
            listSiswa = try {
                StatusUiSiswa.Success(repositoryDataSiswa.getDataSiswa())
            }catch (e: IOException){
                StatusUiSiswa.Error
            }catch (e: HttpException){
                StatusUiSiswa.Error
            }
        }
    }
}