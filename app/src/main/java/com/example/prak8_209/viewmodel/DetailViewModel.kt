package com.example.prak8_209.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.prak8_209.model.DataSiswa
import com.example.prak8_209.repository.RepositoryDataSiswa
import com.example.prak8_209.view.route.DestinasiDetail
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.Response

sealed interface StatusUiDetail{
    data class Success(val satuSiswa: DataSiswa): StatusUiDetail
    object Error: StatusUiDetail
    object Loading: StatusUiDetail
}
class DetailViewModel (savedStateHandle: SavedStateHandle,
    private val repositoryDataSiswa: RepositoryDataSiswa): ViewModel(){
        private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])
    var statusUiDetail: StatusUiDetail by mutableStateOf(StatusUiDetail.Loading)
        private set
    init {
        getSatuSiswa()
    }
    fun getSatuSiswa(){
        viewModelScope.launch {
            statusUiDetail = StatusUiDetail.Loading
            statusUiDetail = try {
                StatusUiDetail.Success(satuSiswa = repositoryDataSiswa.getSatuSiswa(idSiswa))
            }
            catch (e: IOException){
                StatusUiDetail.Error
            }
            catch (e: HttpException){
                StatusUiDetail.Error
            }
        }
    }
    @SuppressLint("SuspiciousIndentation")
    suspend fun hapusSatuSiswa(){
        val resp: Response<Void> = repositoryDataSiswa.hapusSatuSiswa(idSiswa)

        if (resp.isSuccessful){
            println("Sukses hapus data: ${resp.message()}")
        } else{
            println("Gagal hapus data: ${resp.errorBody()}")
        }
    }
    }