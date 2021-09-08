package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMixViewPagerBinding

class MixViewPager : AppCompatActivity() {

    private lateinit var binding: ActivityMixViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMixViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}