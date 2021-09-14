package com.example.myapplication

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.myapplication.databinding.ImageContainerItemBinding
import com.example.myapplication.databinding.VideoContainerItemBinding

sealed class ViewPagerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root){

    class VideoViewHolder(private val binding: VideoContainerItemBinding): ViewPagerViewHolder(binding){
        fun setVideoData(videoItem: ViewPagerItem.VideoItem){
            val mc = android.widget.MediaController(binding.root.context)
            mc.setMediaPlayer(binding.reelsVideoView)
            mc.setAnchorView(binding.reelsVideoView)

            binding.reelsVideoView.setVideoURI(Uri.parse(videoItem.videoPath))
            binding.reelsVideoView.setMediaController(mc)
            binding.reelsVideoView.requestFocus()
            binding.reelsVideoView.start()

            binding.reelsVideoView.setOnPreparedListener {
                binding.reelsProgressBar.visibility = View.GONE
                binding.textMediaTitle.text = videoItem.videoTitle
                binding.textMediaDescription.text = videoItem.videoDescription

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

    class ImageViewHolder(private val binding: ImageContainerItemBinding): ViewPagerViewHolder(binding){
        fun setImageData(imageItem: ViewPagerItem.ImageItem){
            binding.imageReelsImageView.setImageURI(Uri.parse(imageItem.imagePath))
            binding.imageReelsImageDescription.text = imageItem.imageDescription
            binding.imageReelsImageTitle.text = imageItem.imageTitle
            binding.imageReelsImageView.requestFocus()
        }
    }
}
