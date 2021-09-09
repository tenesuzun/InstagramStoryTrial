package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.net.Uri
import com.example.myapplication.databinding.ImageContainerItemBinding
import com.example.myapplication.databinding.VideoContainerItemBinding

class ViewPagerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var items = listOf<ViewPagerItem>()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    lateinit var videoBinding: VideoContainerItemBinding
    lateinit var imageBinding: ImageContainerItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            R.layout.video_container_item -> VideoViewHolder(VideoContainerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
            R.layout.image_container_item -> ImageViewHolder(ImageContainerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is VideoViewHolder -> {
                holder.setVideoData(items[position] as ViewPagerItem.VideoItem)
            }
            is ImageViewHolder -> {
                holder.setImageData(items[position] as ViewPagerItem.ImageItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is ViewPagerItem.ImageItem -> R.layout.image_container_item
            is ViewPagerItem.VideoItem -> R.layout.video_container_item
        }
    }

    inner class VideoViewHolder(binding: VideoContainerItemBinding): RecyclerView.ViewHolder(binding.root){
        fun setVideoData(videoItem: ViewPagerItem.VideoItem){

            val mc = android.widget.MediaController(videoBinding.root.context)
            mc.setMediaPlayer(videoBinding.reelsVideoView)
            mc.setAnchorView(videoBinding.reelsVideoView)

            videoBinding.reelsVideoView.setVideoURI(Uri.parse(videoItem.videoPath))
            videoBinding.reelsVideoView.setMediaController(mc)
            videoBinding.reelsVideoView.requestFocus()
            videoBinding.reelsVideoView.start()

            videoBinding.reelsVideoView.setOnPreparedListener {
                videoBinding.reelsProgressBar.visibility = View.GONE
                videoBinding.textMediaTitle.text = videoItem.videoTitle
                videoBinding.textMediaDescription.text = videoItem.videoDescription

                val videoRatio: Float = it.videoHeight.toFloat() / it.videoHeight.toFloat()
                val screenRatio: Float = videoBinding.reelsVideoView.width.toFloat() / videoBinding.reelsVideoView.height.toFloat()
                val scale: Float = videoRatio / screenRatio
                if(scale >= 1f) {
                    videoBinding.reelsVideoView.scaleX = scale
                } else {
                    videoBinding.reelsVideoView.scaleY = 1f / scale
                }
            }
            videoBinding.reelsVideoView.setOnCompletionListener{
                it.start()
            }
        }
    }

    inner class ImageViewHolder(binding: ImageContainerItemBinding): RecyclerView.ViewHolder(binding.root){
        fun setImageData(imageItem: ViewPagerItem.ImageItem){
            imageBinding.imageReelsImageView.setImageURI(Uri.parse(imageItem.imagePath))
            imageBinding.imageReelsImageDescription.text = imageItem.imageDescription
            imageBinding.imageReelsImageTitle.text = imageItem.imageTitle
            imageBinding.imageReelsImageView.requestFocus()
        }
    }
}