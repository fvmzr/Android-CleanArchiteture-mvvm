package com.example.android_sample.features

import com.example.android_sample.core.const.Const
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MoviesApi {
    @GET(Const.ServiceType.BASE_URL)
    fun movies(
        @Query(Const.ServiceType.API_KEY) apikey: String,
        @Query(Const.ServiceType.MOVIES) s: String
    ): Call<MovieEntity>

}