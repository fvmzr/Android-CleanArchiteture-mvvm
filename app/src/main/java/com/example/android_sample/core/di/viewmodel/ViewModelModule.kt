package com.example.android_sample.core.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_sample.features.viewmodel.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindMoviesViewModel(moviesViewModel:MoviesViewModel) :ViewModel
}

