package com.ssp.common_ui.imageloader

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.ssp.common_ui.R

class ImageLoaderImpl constructor(
    private val context: Context
) : com.ssp.core.ImageLoader {

    private var picasso: Picasso = Picasso
        .Builder(context)
        .build()

    override fun cacheImage(imageUrl: String) {
        picasso.load(imageUrl)
            .fetch()
    }

    override fun loadImage(
        imageUrl: String,
        imageView: ImageView
    ) {
        picasso
            .load(imageUrl)
            .placeholder(R.drawable.ic_loading)
            .centerInside()
            .fit()
            .into(imageView)
    }
}