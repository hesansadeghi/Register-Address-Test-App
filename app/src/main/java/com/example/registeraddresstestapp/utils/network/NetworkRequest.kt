package com.example.registeraddresstestapp.utils.network

sealed class NetworkRequest<T>(val data: T? = null, val error: String? = null) {

    class Success<T>(data: T) : NetworkRequest<T>(data)
    class Error<T>(message: String?) : NetworkRequest<T>(error = message)
}