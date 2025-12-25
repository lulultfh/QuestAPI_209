package com.example.prak8_209.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prak8_209.model.DetailSiswa
import com.example.prak8_209.model.UIStateSiswa
import com.example.prak8_209.model.toUIStateSiswa
import com.example.prak8_209.repository.RepositoryDataSiswa
import kotlinx.coroutines.launch

class EditViewModel (savedStateHandle: SavedStateHandle,private val repositoryDataSiswa: RepositoryDataSiswa)
    : ViewModel(){
        var uiStateSiswa by mutableStateOf(UIStateSiswa())
                private set
    private  val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])
    init {
        viewModelScope.launch {
            uiStateSiswa = repositoryDataSiswa.getSatuSiswa(idSiswa).toUIStateSiswa(true)
        }
    }
    fun updateUiState(detailSiswa: DetailSiswa){
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
    }