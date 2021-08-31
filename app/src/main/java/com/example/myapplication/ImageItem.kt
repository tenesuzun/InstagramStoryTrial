package com.example.myapplication

import android.net.Uri

data class ImageItem (
    var imageUri: Uri,
    var imageTitle: String,
    var imageDescription: String
    )