package com.example.registeraddresstestapp.api.model


import com.google.gson.annotations.SerializedName

data class RegisterBody(
    @SerializedName("address")
    var address: String?, // tehran
    @SerializedName("coordinate_mobile")
    var coordinateMobile: String?, // 09362225588
    @SerializedName("coordinate_phone_number")
    var coordinatePhoneNumber: String?, // 02188236999
    @SerializedName("first_name")
    var firstName: String?, // ali
    @SerializedName("gender")
    var gender: String?, // Male
    @SerializedName("last_name")
    var lastName: String?, // rezae
    @SerializedName("lat")
    var lat: Double?, // 35.7717503
    @SerializedName("lng")
    var lng: Double?, // 51.3365315
    @SerializedName("region")
    var region: Int? = 1
)