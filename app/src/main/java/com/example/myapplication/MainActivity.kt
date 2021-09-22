package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        RetrofitApi.setImagesFromAPI()
        RetrofitApi.setVideosFromAPI()

        binding.button2.setOnClickListener{
            d("VideoBtn","Video Btn is clicked")
            startActivity(Intent(this, VideoViewPager::class.java))
        }

        binding.button.setOnClickListener{
            d("ImageBtn", "Image Btn is clicked")
            startActivity(Intent(this, ImageViewPager::class.java))
        }

        binding.button3.setOnClickListener{
            d("MixBtn","Mix btn is clicked")
            startActivity(Intent(this, MixViewPager::class.java))
        }
    }
}