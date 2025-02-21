package com.example.registeraddresstestapp.api.model


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("address")
    var address: String?, // tehran
    @SerializedName("address_id")
    var addressId: String?, // 072bc26d-1ec0-411c-ac18-e26139e76d1d
    @SerializedName("coordinate_mobile")
    var coordinateMobile: String?, // 989362225588
    @SerializedName("coordinate_phone_number")
    var coordinatePhoneNumber: String?, // 982188236999
    @SerializedName("first_name")
    var firstName: String?, // تست
    @SerializedName("gender")
    var gender: String?,
    @SerializedName("id")
    var id: String?, // 665813
    @SerializedName("last_name")
    var lastName: String?, // اکانت
    @SerializedName("lat")
    var lat: Double?, // 35.7717503
    @SerializedName("lng")
    var lng: Double?, // 51.3365315
    @SerializedName("region")
    var region: Region?
) {
    data class Region(
        @SerializedName("city_object")
        var cityObject: CityObject?,
        @SerializedName("id")
        var id: Int?, // 1
        @SerializedName("name")
        var name: String?, // لویزان  -  شیان
        @SerializedName("state_object")
        var stateObject: StateObject?
    ) {
        data class CityObject(
            @SerializedName("city_id")
            var cityId: Int?, // 333
            @SerializedName("city_name")
            var cityName: String? // تهران
        )

        data class StateObject(
            @SerializedName("state_id")
            var stateId: Int?, // 8
            @SerializedName("state_name")
            var stateName: String? // تهران
        )
    }
}