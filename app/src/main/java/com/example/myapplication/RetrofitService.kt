package com.example.myapplication

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("/v1/link/531")
    fun getFullResponse(): Call<ResponseBody>
}