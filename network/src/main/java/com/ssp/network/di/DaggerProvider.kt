package com.ssp.network.di

object DaggerProvider {

    val component: NetworkComponent by lazy {
        DaggerNetworkComponent.factory().create()
    }
}