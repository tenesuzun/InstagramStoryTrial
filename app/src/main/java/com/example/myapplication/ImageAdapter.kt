package com.example.myapplication

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.reelsImageView)
        val textImageTitle: TextView = itemView.findViewById(R.id.textImageTitle)
        val textImageDescription: TextView = itemView.findViewById(R.id.textImageDescription)
        val imageProgressBar: ProgressBar = itemView.findViewById(R.id.reelsProgressBar)

        fun setImageData(imageItem: ImageItem){
            textImageTitle.text = imageItem.imageTitle
            textImageDescription.text = imageItem.imageDescription
            imageView.setImageURI(imageItem.imageUri)
            imageView.setOnP
        }
    }


}