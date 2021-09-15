package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityImageViewPagerBinding
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageViewPager : AppCompatActivity() {

    private lateinit var binding: ActivityImageViewPagerBinding
    private var imageItems: MutableList<ViewPagerItem.ImageItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPagerAdapter = ViewPagerAdapter()

        getApiResponse()

        imageItems.add(
            ViewPagerItem.ImageItem(
                imagePath = "https://images.pexels.com/photos/9504478/pexels-photo-9504478.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2&amp;w=500",
                imageTitle = "Window on a wall",
                imageDescription = "A window placed on wall with surface made of rock"
            )
        )

        imageItems.add(
            ViewPagerItem.ImageItem(
                imagePath = "https://images.pexels.com/photos/1590549/pexels-photo-1590549.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
                imageTitle = "Fall has come",
                imageDescription = "Blurry yellow leaves with a shining sun light in the background"
            )
        )

        imageItems.add(
            ViewPagerItem.ImageItem(
                imagePath = "https://images.pexels.com/photos/3586966/pexels-photo-3586966.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
                imageTitle = "CyberPunk?",
                imageDescription = "Picture of a city in the night time that shows the bridge"
            )
        )

        imageItems.add(
            ViewPagerItem.ImageItem(
                imagePath = "https://images.pexels.com/photos/242201/pexels-photo-242201.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
                imageTitle = "Emptiness?",
                imageDescription = "There is a bench standing empty in the woods with some leaves on it"
            )
        )

        imageItems.add(
            ViewPagerItem.ImageItem(
                imagePath = "https://images.pexels.com/photos/1592384/pexels-photo-1592384.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
                imageTitle = "Vintage Car",
                imageDescription = "A car everyone would want to experience driving at some point in their life"
            )
        )

        imageItems.add(
            ViewPagerItem.ImageItem(
                imagePath = "https://images.pexels.com/photos/1651165/pexels-photo-1651165.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
                imageTitle = "Leaves on the road",
                imageDescription = "This road could be best to drive through to collect some thoughts"
            )
        )
        viewPagerAdapter.items = imageItems
        binding.imagesViewPager.adapter = viewPagerAdapter
    }

    fun getImagesFromJsonObject(response: JSONObject){
        imageItems.add(ViewPagerItem.ImageItem(
            imagePath = response.get("primaryImage").toString(),
            imageDescription = "Description",
            imageTitle = "Title"
        ))
    }

    private fun getApiResponse(){
        RetrofitApi.retrofit.getFullResponse().enqueue(object: Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                when(response.code()){
                    200 -> {
                        JSONObject(response.body()!!.string())
                        getImagesFromJsonObject(JSONObject(response.body()!!.string()))
                    }else -> {
                        Toast.makeText(binding.root.context,response.code().toString()+" "+ response.message(), Toast.LENGTH_LONG).show()
                    }
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(binding.root.context,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
}