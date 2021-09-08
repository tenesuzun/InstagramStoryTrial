package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityImageViewPagerBinding

class ImageViewPager : AppCompatActivity() {

    private lateinit var binding: ActivityImageViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}