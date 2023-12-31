package com.ssp.feature_one.di

import com.ssp.common_ui.di.ViewModelBuilderModule
import com.ssp.core.di.CoreComponent
import com.ssp.feature_one.ui.DetailActivity
import com.ssp.feature_one.ui.FeatureOneActivity
import dagger.Component

@Component(
    dependencies = [
        CoreComponent::class
    ],
    modules = [FeatureOneModule::class, FeatureOneViewModelModule::class, ViewModelBuilderModule::class]
)
interface FeatureOneComponent {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent
        ): FeatureOneComponent
    }

    fun inject(activity: FeatureOneActivity)

    fun inject(activity: DetailActivity)
}