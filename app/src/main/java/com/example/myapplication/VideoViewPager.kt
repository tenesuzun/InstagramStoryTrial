package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityVideoViewPagerBinding
import retrofit2.Call
import retrofit2.Callback

class VideoViewPager : AppCompatActivity() {

    private lateinit var binding: ActivityVideoViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoAdapter = ViewPagerAdapter()

        RetrofitApi.retrofit.getVideoResponse().enqueue(object: Callback<VideoResponse>{
            override fun onResponse(call: Call<VideoResponse>, response: retrofit2.Response<VideoResponse>) {
                when(response.code()){
                    200 -> {
                        videoAdapter.items = response.body()!!.data.videos.ResponsedVideo.toMutableList()
                        binding.videosViewPager.adapter = videoAdapter
                    } else -> {
                        Toast.makeText(binding.root.context, response.code().toString()+" "+response.message(),Toast.LENGTH_LONG).show()
                    }
                }
            }
            override fun onFailure(call: Call<VideoResponse>, t: Throwable) {
                Toast.makeText(binding.root.context, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}