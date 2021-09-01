package com.example.myapplication

import android.media.MediaPlayer
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoView: VideoView = itemView.findViewById(R.id.reelsVideoView)
        val textVideoTitle: TextView = itemView.findViewById(R.id.textMediaTitle)
        val textImageDescription: TextView = itemView.findViewById(R.id.textMediaDescription)
        val videoProgressBar: ProgressBar = itemView.findViewById(R.id.reelsProgressBar)

        fun setImageData(videoItem: VideoItem){
            textVideoTitle.text = videoItem.videoTitle
            textImageDescription.text = videoItem.videoDescription
            videoView.setVideoPath(videoItem.videoPath)
            videoView.setOnPreparedListener {
                videoProgressBar.visibility = View.GONE
                it.start()

                val videoRatio: Float = it.videoHeight.toFloat() / it.videoHeight.toFloat()
                val screenRatio: Float = videoView.width.toFloat() / videoView.height.toFloat()
                val scale: Float = videoRatio / screenRatio
                if(scale >= 1f) {
                    videoView.scaleX = scale
                } else {
                    videoView.scaleY = 1f / scale
                }
            }
            videoView.setOnCompletionListener{
                it.start()
            }
        }
    }


}