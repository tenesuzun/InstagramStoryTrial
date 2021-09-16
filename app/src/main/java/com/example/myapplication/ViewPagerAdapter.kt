package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ImageContainerItemBinding
import com.example.myapplication.databinding.VideoContainerItemBinding
import kotlin.IllegalArgumentException

class ViewPagerAdapter: RecyclerView.Adapter<ViewPagerViewHolder>(){

    var items = listOf<Any>()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return when(viewType){
            R.layout.video_container_item -> ViewPagerViewHolder.VideoViewHolder(
                VideoContainerItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.image_container_item -> ViewPagerViewHolder.ImageViewHolder(
                ImageContainerItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid viewType provided")
        }
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        when(holder){
            is ViewPagerViewHolder.ImageViewHolder -> holder.setImageData(items[position] as Response)
            is ViewPagerViewHolder.VideoViewHolder -> holder.setVideoData(items[position] as ViewPagerItem.VideoItem)
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is Response -> R.layout.image_container_item
            is ViewPagerItem.VideoItem -> R.layout.video_container_item
            else -> throw IllegalArgumentException("No layout for the item type ${items[position].javaClass}")
        }
    }
}