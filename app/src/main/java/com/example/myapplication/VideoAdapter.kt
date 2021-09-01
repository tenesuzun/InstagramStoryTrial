package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(private val videoItems: MutableList<VideoItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val videoView: VideoView = itemView.findViewById(R.id.reelsVideoView)
        private val textVideoTitle: TextView = itemView.findViewById(R.id.textMediaTitle)
        private val textImageDescription: TextView = itemView.findViewById(R.id.textMediaDescription)
        private val videoProgressBar: ProgressBar = itemView.findViewById(R.id.reelsProgressBar)

        fun setVideoData(videoItem: VideoItem){
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.media_container_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is ImageViewHolder -> {
                holder.setVideoData(videoItems[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return videoItems.size
    }


}