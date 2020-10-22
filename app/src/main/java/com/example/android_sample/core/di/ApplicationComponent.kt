package com.example.android_sample.core.di

import com.example.android_sample.AndroidApplication
import com.example.android_sample.core.di.viewmodel.ViewModelModule
import com.example.android_sample.features.view.MoviesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(moviesFragment: MoviesFragment)

}