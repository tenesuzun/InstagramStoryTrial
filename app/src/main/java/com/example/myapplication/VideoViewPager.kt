package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class VideoViewPager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view_pager)

        val videosViewPager: ViewPager2 = findViewById(R.id.videosViewPager)
        val videoAdapter = ViewPagerAdapter()

        val videoItems: MutableList<ViewPagerItem.VideoItem> = ArrayList()

        val videoItemCelebration = ViewPagerItem.VideoItem(
            videoPath = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            videoTitle = "Yellow Flower",
            videoDescription = "This is a video of a yellow flower"
        )
        videoItems.add(videoItemCelebration)

        val videoItemParty = ViewPagerItem.VideoItem(
            videoPath = "https://player.vimeo.com/external/546875025.hd.mp4?s=8bbfa683c757a59a303740c74a5af7cc916970b5&amp;profile_id=175&amp;oauth2_token_id=57447761",
            videoTitle = "Off White Brush Paint",
            videoDescription = "Brush painted in slightly off white"
        )
        videoItems.add(videoItemParty)

        val videoItemThirdVideo = ViewPagerItem.VideoItem(
            videoPath = "https://vod-progressive.akamaized.net/exp=1630603895~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F757%2F16%2F403787488%2F1727245276.mp4~hmac=d48c12ce8d5e92c3ba95fa8c5e5d5cc7ef4903b6c7054989490b8df9476c2cc5/vimeo-prod-skyfire-std-us/01/757/16/403787488/1727245276.mp4?filename=production+ID%3A4068409.mp4",
            videoTitle = "Painting board ",
            videoDescription = "You can see the hand painting the board with a brush"
        )
        videoItems.add(videoItemThirdVideo)

        val videoItemFourthVideo = ViewPagerItem.VideoItem(
            videoPath = "http://www.techslides.com/demos/sample-videos/small.mp4",
            videoTitle = "Mixed colors ",
            videoDescription = "Colors are mixed and spread on the surface of a puddle"
        )
        videoItems.add(videoItemFourthVideo)

        val videoItemFifthVideo = ViewPagerItem.VideoItem(
            videoPath = "app/sampledata/fifth_video",
            videoTitle = "Color Palette ",
            videoDescription = "Painter is selecting colors from her palette"
        )
        videoItems.add(videoItemFifthVideo)

        val videoItemSixthVideo = ViewPagerItem.VideoItem(
            videoPath = "app/sampledata/sixth_video",
            videoTitle = "Indoor painting",
            videoDescription = "Painter is working indoor while holding her color palette"
        )
        videoItems.add(videoItemSixthVideo)

        videoAdapter.items = videoItems
        videosViewPager.adapter = videoAdapter
    }
}