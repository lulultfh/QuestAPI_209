package com.example.prak8_209.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.prak8_209.model.UIStateSiswa
import com.example.prak8_209.repository.RepositoryDataSiswa

class EditViewModel (savedStateHandle: SavedStateHandle,private val repositoryDataSiswa: RepositoryDataSiswa)
    : ViewModel(){
        var uiStateSiswa by mutableStateOf(UIStateSiswa())
                private set
    }