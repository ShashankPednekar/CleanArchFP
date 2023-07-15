package com.ssp.feature_one.di

import com.ssp.core.di.CoreComponentProvider


object FeatureOneDaggerProvider {

    val component: FeatureOneComponent by lazy {
        DaggerFeatureOneComponent.factory().create(
            coreComponent = CoreComponentProvider.coreComponent
        )
    }
}