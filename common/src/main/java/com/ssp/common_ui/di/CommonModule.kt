package com.ssp.common_ui.di

import android.content.Context
import com.ssp.common_ui.imageloader.ImageLoaderImpl
import com.ssp.core.ImageLoader
import dagger.Module
import dagger.Provides

@Module
class CommonModule {

    @Provides
    fun getImageLoader(
        context: Context
    ): ImageLoader {
        return ImageLoaderImpl(
            context = context
        )
    }
}