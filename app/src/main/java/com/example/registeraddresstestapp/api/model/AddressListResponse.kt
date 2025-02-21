package com.example.registeraddresstestapp.api.model


import com.google.gson.annotations.SerializedName

class AddressListResponse : ArrayList<AddressListResponse.ResponseAddressListItem>(){
    data class ResponseAddressListItem(
        @SerializedName("address")
        var address: String?, // تهران، بزرگراه شیخ فضل الله نوری، سازمان آب، بین یاورنژاد و حاجی پور امیر
        @SerializedName("address_id")
        var addressId: String?, // d0f121ae-fe1d-467c-ac7b-8d48348d4bac
        @SerializedName("coordinate_mobile")
        var coordinateMobile: String?, // 989369999999
        @SerializedName("coordinate_phone_number")
        var coordinatePhoneNumber: String?, // 989666666666
        @SerializedName("first_name")
        var firstName: String?, // تست
        @SerializedName("gender")
        var gender: String?,
        @SerializedName("id")
        var id: String?, // 665850
        @SerializedName("last_name")
        var lastName: String?, // اکانت
        @SerializedName("lat")
        var lat: Double?, // 35.725858974352924
        @SerializedName("lng")
        var lng: Double?, // 51.35789437773498
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
}