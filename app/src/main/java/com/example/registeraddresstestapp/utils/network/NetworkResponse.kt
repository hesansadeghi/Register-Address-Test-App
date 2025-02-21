package com.example.registeraddresstestapp.utils.network

import com.example.registeraddresstestapp.api.model.ResponseError
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Response

open class NetworkResponse<T>(private val response: Response<T>) {

    fun generateResponse(): NetworkRequest<T> {

        return when {

            response.isSuccessful -> NetworkRequest.Success(response.body()!!)

//            response.code() == 400 -> NetworkRequest.Error(getErrorMessage(response.errorBody()))
//
//            response.code() == 403 -> NetworkRequest.Error(getErrorMessage(response.errorBody()))
//
//            response.code() == 500  -> NetworkRequest.Error(getErrorMessage(response.errorBody()))

            response.message().contains("timeout") -> NetworkRequest.Error("Timeout")

            else -> NetworkRequest.Error(getErrorMessage(response.errorBody()))

//            else -> NetworkRequest.Error(response.message())

        }

    }


    private fun getErrorMessage(errorBody: ResponseBody?):String{

        var errorMessage = ""
        if (errorBody != null) {

            val responseError = Gson().fromJson(
                errorBody.charStream(),
                ResponseError::class.java
            )

            errorMessage = responseError.error
        }

        return errorMessage
    }


}