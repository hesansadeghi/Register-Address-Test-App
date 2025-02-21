package com.example.registeraddresstestapp.api.model

import com.google.gson.annotations.SerializedName

data class ResponseError(
    @SerializedName("detail")
    val error: String,
)
