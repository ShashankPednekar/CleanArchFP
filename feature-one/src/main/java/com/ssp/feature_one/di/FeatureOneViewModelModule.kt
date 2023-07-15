package com.ssp.feature_one.di

import androidx.lifecycle.ViewModel
import com.ssp.common_ui.di.ViewModelKey
import com.ssp.feature_one.viewmodel.FeatureOneViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FeatureOneViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FeatureOneViewModel::class)
    abstract fun bindViewModel(viewModel: FeatureOneViewModel): ViewModel
}