package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    private var BASE_URL: String = "https://api.tmgrup.com.tr"

    val retrofit: RetrofitService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitService::class.java)

    fun changeBaseUrl(tempString: String){
        BASE_URL = tempString
    }
}