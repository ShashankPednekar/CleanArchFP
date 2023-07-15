package com.ssp.feature_two.di

import com.ssp.core.di.CoreComponent
import com.ssp.feature_two.FeatureTwoActivity
import dagger.Component

@Component(
    dependencies = [
        CoreComponent::class
    ]
)
interface FeatureTwoComponent {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent
        ): FeatureTwoComponent
    }

    fun inject(activity: FeatureTwoActivity)
}