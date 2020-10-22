package com.example.android_sample.features

import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesService
@Inject constructor(retrofit :Retrofit) :MoviesApi{
    private val moviewApi by lazy {retrofit.create(MoviesApi ::class.java)}

    override fun movies(apikey: String, s: String) = moviewApi.movies(apikey, s)
}