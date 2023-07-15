package com.ssp.core.di

import android.content.Context
import com.ssp.core.ImageLoader
import com.ssp.core.NetworkManager
import com.ssp.core.NetworkProvider

interface CoreComponent {

    fun getContext(): Context

    fun getImageLoader(): ImageLoader

    fun getNetworkProvider(): NetworkProvider

    fun getNetworkManager(): NetworkManager
}