package com.example.registeraddresstestapp.api

import com.example.registeraddresstestapp.api.model.AddressListResponse
import com.example.registeraddresstestapp.api.model.RegisterBody
import com.example.registeraddresstestapp.api.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface KarfarmasApi {

    @POST("address")
    suspend fun postRegister(@Body body: RegisterBody): Response<RegisterResponse>


    @GET("address")
    suspend fun getAddressList(): Response<AddressListResponse>

}