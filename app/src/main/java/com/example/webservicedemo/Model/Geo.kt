package com.example.webservicedemo.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Geo {

    @SerializedName("lat")
    @Expose
    var lat: String? = null
    @SerializedName("lng")
    @Expose
    var lng: String? = null

}


