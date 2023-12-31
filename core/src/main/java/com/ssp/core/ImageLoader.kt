package com.ssp.core

import android.widget.ImageView

interface ImageLoader {

    fun cacheImage(
        imageUrl: String
    )

    fun loadImage(
        imageUrl: String,
        imageView: ImageView
    )
}