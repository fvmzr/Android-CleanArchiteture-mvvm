package com.example.android_sample

import android.app.Application
import com.example.android_sample.core.di.ApplicationComponent
import com.example.android_sample.core.di.ApplicationModule

import com.example.android_sample.core.di.DaggerApplicationComponent
import dagger.android.DaggerApplication_MembersInjector

class AndroidApplication : Application() {
    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)
}