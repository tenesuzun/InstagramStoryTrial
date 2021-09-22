package com.example.myapplication

import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    lateinit var imageList: MutableList<com.example.myapplication.Response>
    lateinit var videoList: MutableList<ResponsedVideo>

    private var BASE_URL: String = "https://api.tmgrup.com.tr"

    val retrofit: RetrofitService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitService::class.java)

    fun setImagesFromAPI(){
        retrofit.getFullResponse().enqueue(object: Callback<ImageResponse>{
            override fun onResponse(call: Call<ImageResponse>, response: Response<ImageResponse>) {
                imageList = response.body()!!.data.articles.Response.toMutableList()
            }

            override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                d("Images_FAILURE", "setImagesFromApi Failed!!!")
            }
        })
    }

    fun getImagesList(): MutableList<com.example.myapplication.Response>{
        return imageList
    }

    fun setVideosFromAPI(){
        retrofit.getVideoResponse().enqueue(object: Callback<VideoResponse>{
            override fun onResponse(call: Call<VideoResponse>, response: Response<VideoResponse>) {
                videoList = response.body()!!.data.videos.ResponsedVideo.toMutableList()
            }

            override fun onFailure(call: Call<VideoResponse>, t: Throwable) {
                d("Videos_FAILURE","setVideosFromAPI Failed!!!")
            }
        })
    }

    fun getVideosList(): MutableList<ResponsedVideo>{
        return videoList
    }
}