package com.ssp.assignmentfp

import android.app.Application
import com.ssp.assignmentfp.di.AppComponent
import com.ssp.assignmentfp.di.DaggerAppComponent
import com.ssp.assignmentfp.di.DaggerAppComponentProvider
import com.ssp.core.di.CoreComponentProvider

class AssignmentApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appComponent: AppComponent = DaggerAppComponent.factory().create(this)
        DaggerAppComponentProvider.setAppComponent(appComponent)
        CoreComponentProvider.coreComponent = appComponent
    }
}