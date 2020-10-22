package com.example.android_sample.features


import android.util.Log
import com.example.android_sample.core.exception.Failure
import com.example.android_sample.core.functional.Either
import com.example.android_sample.core.platform.NetworkHandler
import retrofit2.Call
import javax.inject.Inject

interface MoviesRepository {

    fun movies(apikey: String, s: String): Either<Failure, Movie>

    class Network
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: MoviesService
    ) : MoviesRepository {

        override fun movies(apikey: String, s: String): Either<Failure, Movie> {
            return when (networkHandler.isConnected) {
                true -> request(service.movies(apikey, s), {  it.toMovie()  }, MovieEntity.empty())
                false, null -> Either.Left(Failure.NetworkConnection)
            }
        }

        private fun <T, R> request(
            call: Call<T>,
            transform: (T) -> R,
            default: T
        ): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform(response.body() ?: default))
                    false -> {
                        Either.Left(Failure.ServerError)
                    }
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }

    }
}