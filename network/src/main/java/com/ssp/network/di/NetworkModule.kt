package com.ssp.network.di

import android.content.Context
import com.ssp.core.NetworkManager
import com.ssp.core.NetworkProvider
import com.ssp.network.manager.NetworkManagerImpl
import com.ssp.network.provider.NetworkProviderImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun getNetworkManager(
        context: Context
    ): NetworkManager {
        return NetworkManagerImpl(
            context = context
        )
    }

    @Provides
    fun getNetworkProvider(): NetworkProvider {
        return NetworkProviderImpl()
    }
}