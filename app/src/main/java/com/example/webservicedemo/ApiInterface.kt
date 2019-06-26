package com.example.webservicedemo

import com.example.webservicedemo.Model.UserData
import retrofit2.Call
import retrofit2.http.GET



interface ApiInterface {

    @GET("users")
    fun getuserdata(): Call<List<UserData>>

}
