package com.ssp.feature_two.di

import com.ssp.core.di.CoreComponentProvider

object FeatureTwoDaggerProvider {

    val component: FeatureTwoComponent by lazy {
        DaggerFeatureTwoComponent.factory().create(
            coreComponent = CoreComponentProvider.coreComponent
        )
    }
}