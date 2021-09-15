package com.example.myapplication

sealed class ViewPagerItem{

    data class VideoItem(
        var videoPath: String,
        var videoTitle: String,
        var videoDescription: String
    ): ViewPagerItem()

    data class ImageItem(
        var imagePath: String,
        var imageTitle: String,
        var imageDescription: String
    ): ViewPagerItem()
}

