package com.ssp.feature_one.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ssp.core.ImageLoader
import com.ssp.feature_one.R
import com.ssp.feature_one.data.Post
import com.ssp.feature_one.databinding.ActivityDetailBinding
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val post: Post? = intent?.getSerializableExtra("post") as? Post
        post?.let {
            binding.post = it
            imageLoader.loadImage(post.url, binding.ivImage)
        }
    }
}