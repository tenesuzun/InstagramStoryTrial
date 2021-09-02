package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.MediaContainerItemBinding

class VideoAdapter(private val videosList: MutableList<VideoItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    lateinit var binding: MediaContainerItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = MediaContainerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewPagerViewHolder -> {
                holder.setVideoData(videosList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return videosList.size
    }

    inner class ViewPagerViewHolder(binding: MediaContainerItemBinding): RecyclerView.ViewHolder(binding.root){
        fun setVideoData(videoItem: VideoItem){
            binding.textMediaTitle.text = videoItem.videoTitle
            binding.textMediaDescription.text = videoItem.videoDescription
//            binding.reelsVideoView.setVideoPath(videoItem.videoPath)
            binding.reelsVideoView.setOnPreparedListener {
                binding.reelsProgressBar.visibility = View.GONE
                it.setDataSource(videoItem.videoPath)
                it.start()

                val videoRatio: Float = it.videoHeight.toFloat() / it.videoHeight.toFloat()
                val screenRatio: Float = binding.reelsVideoView.width.toFloat() / binding.reelsVideoView.height.toFloat()
                val scale: Float = videoRatio / screenRatio
                if(scale >= 1f) {
                    binding.reelsVideoView.scaleX = scale
                } else {
                    binding.reelsVideoView.scaleY = 1f / scale
                }
            }
            binding.reelsVideoView.setOnCompletionListener{
                it.start()
            }
        }
    }
}