package com.example.registeraddresstestapp.repositories

import com.example.registeraddresstestapp.api.KarfarmasApi
import com.example.registeraddresstestapp.api.NeshanApi
import com.example.registeraddresstestapp.api.model.RegisterBody
import com.example.registeraddresstestapp.utils.Utils
import retrofit2.http.Query
import javax.inject.Inject

class RegisterRepository @Inject constructor(
    private val karfarmasApi: KarfarmasApi,
    private val neshanApi: NeshanApi
) {

    suspend fun postRegister(body: RegisterBody) =
        karfarmasApi.postRegister(body)


    suspend fun getAddressList() =
        karfarmasApi.getAddressList()


    suspend fun getAddress(lat: Double, lng: Double) = neshanApi.getAddress(Utils.API_KEY, lat, lng)


}