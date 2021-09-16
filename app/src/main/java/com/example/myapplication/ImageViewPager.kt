package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityImageViewPagerBinding
import retrofit2.Call
import retrofit2.Callback

class ImageViewPager : AppCompatActivity() {

    private lateinit var binding: ActivityImageViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPagerAdapter = ViewPagerAdapter()

        RetrofitApi.retrofit.getFullResponse().enqueue(object: Callback<ImageResponse> {
            override fun onResponse(call: Call<ImageResponse>, response: retrofit2.Response<ImageResponse>) {
                when(response.code()){
                    200 -> {
                        viewPagerAdapter.items = response.body()!!.data.articles.Response.toMutableList()
                        binding.imagesViewPager.adapter = viewPagerAdapter
                    }else -> {
                        Toast.makeText(binding.root.context,response.code().toString()+" "+ response.message(), Toast.LENGTH_LONG).show()
                    }
                }
            }
            override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                Toast.makeText(binding.root.context,t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}