package com.ssp.assignmentfp.di

object DaggerAppComponentProvider {

    private var appComponent: AppComponent? = null

    fun setAppComponent(appComponent: AppComponent) {
        this.appComponent = appComponent
    }

    fun getAppComponent(): AppComponent = requireNotNull(appComponent)
}