package com.example.prak8_209.repository

import com.example.prak8_209.model.DataSiswa

interface RepositoryDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa):retrofit2.Response<Void>
}