package com.ssp.feature_one.di

import com.ssp.core.ImageLoader
import com.ssp.feature_one.adapter.PostAdapter
import dagger.Module
import dagger.Provides

@Module
object FeatureOneModule {

    @Provides
    fun photosAdapter(imageLoader: ImageLoader) = PostAdapter(imageLoader)
}