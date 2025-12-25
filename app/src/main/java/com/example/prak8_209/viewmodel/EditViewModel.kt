package com.example.prak8_209.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.prak8_209.repository.RepositoryDataSiswa

class EditViewModel (savedStateHandle: SavedStateHandle,private val repositoryDataSiswa: RepositoryDataSiswa)
    : ViewModel(){}