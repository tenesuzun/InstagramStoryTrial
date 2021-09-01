package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videosViewPager: ViewPager2 = findViewById(R.id.videosViewPager)

        val videoItems: MutableList<VideoItem> = ArrayList()

        val videoItemCelebration = VideoItem(
            videoPath = "app/sampledata/first_video.mp4",
            videoTitle = "Yellow Flower",
            videoDescription = "This is a video of a yellow flower"
        )
        videoItems.add(videoItemCelebration)

        val videoItemParty = VideoItem(
            videoPath = "app/sampledata/second_video",
            videoTitle = "Off White Brush Paint",
            videoDescription = "Brush painted in slightly off white"
        )
        videoItems.add(videoItemParty)

        val videoItemThirdVideo = VideoItem(
            videoPath = "app/sampledata/third_video",
            videoTitle = "Painting board ",
            videoDescription = "You can see the hand painting the board with a brush"
        )
        videoItems.add(videoItemThirdVideo)

        val videoItemFourthVideo = VideoItem(
            videoPath = "app/sampledata/fourth_video",
            videoTitle = "Mixed colors ",
            videoDescription = "Colors are mixed and spread on the surface of a puddle"
        )
        videoItems.add(videoItemFourthVideo)

        val videoItemFifthVideo = VideoItem(
            videoPath = "app/sampledata/fifth_video",
            videoTitle = "Color Palette ",
            videoDescription = "Painter is selecting colors from her palette"
        )
        videoItems.add(videoItemFifthVideo)

        val videoItemSixthVideo = VideoItem(
            videoPath = "app/sampledata/sixth_video",
            videoTitle = "Indoor painting",
            videoDescription = "Painter is working indoor while holding her color palette"
        )
        videoItems.add(videoItemSixthVideo)

        videosViewPager.adapter = VideoAdapter(videoItems)

    }
}