package com.example.registeraddresstestapp.api.model


import com.google.gson.annotations.SerializedName

data class ResponseNeshanAddress(
    @SerializedName("city")
    var city: String?, // تهران
    @SerializedName("county")
    var county: String?, // شهرستان تهران
    @SerializedName("district")
    var district: String?, // بخش مرکزی شهرستان تهران
    @SerializedName("formatted_address")
    var formattedAddress: String?, // تهران، دکتر فاطمی، حجاب، سازمان آب، بین دائمی و عبداله زاده
    @SerializedName("in_odd_even_zone")
    var inOddEvenZone: String?, // true
    @SerializedName("in_traffic_zone")
    var inTrafficZone: String?, // true
    @SerializedName("municipality_zone")
    var municipalityZone: String?, // 6
    @SerializedName("neighbourhood")
    var neighbourhood: String?, // فاطمي
    @SerializedName("place")
    var place: Any?, // null
    @SerializedName("route_name")
    var routeName: String?, // سازمان آب
    @SerializedName("route_type")
    var routeType: String?, // secondary
    @SerializedName("state")
    var state: String?, // استان تهران
    @SerializedName("status")
    var status: String?, // OK
    @SerializedName("village")
    var village: Any? // null
)