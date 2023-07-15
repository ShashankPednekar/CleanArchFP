package com.ssp.assignmentfp.di

import android.content.Context
import com.ssp.assignmentfp.MainActivity
import com.ssp.common_ui.di.CommonModule
import com.ssp.core.di.CoreComponent
import com.ssp.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        CommonModule::class,
        NetworkModule::class,
    ]
)
interface AppComponent : CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context
        ): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}