package com.example.prak8_209.service

import com.example.prak8_209.model.DataSiswa
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApiSiswa{
    @GET("bacateman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertTM.php")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa):retrofit2.Response<Void>
}