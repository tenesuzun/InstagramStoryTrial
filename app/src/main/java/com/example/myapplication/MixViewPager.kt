package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMixViewPagerBinding

class MixViewPager : AppCompatActivity() {

    private lateinit var binding: ActivityMixViewPagerBinding
    private var mediaList: MutableList<Any> = ArrayList()
    private var imageList = RetrofitApi.imageList
    private var videoList = RetrofitApi.videoList
    private var viewPagerAdapter = ViewPagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMixViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for(item in 0 until videoList.size){
            mediaList.add(videoList[item])
            mediaList.add(imageList[item])
        }

        viewPagerAdapter.items = mediaList
        binding.mixViewPager.adapter = viewPagerAdapter
    }
}