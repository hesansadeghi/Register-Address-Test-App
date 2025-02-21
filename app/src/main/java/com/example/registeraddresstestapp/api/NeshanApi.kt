package com.example.registeraddresstestapp.api

import com.example.registeraddresstestapp.api.model.ResponseNeshanAddress
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NeshanApi {


    @GET("reverse")
    suspend fun getAddress(
        @Header("Api-Key") apiKey: String,
        @Query("lat") lat: Double,
        @Query("lng") lng: Double
    ): Response<ResponseNeshanAddress>

}