package com.example.android_sample.features

import com.example.android_sample.core.exception.Failure
import com.example.android_sample.core.functional.Either
import com.example.android_sample.core.interactor.UseCase
import javax.inject.Inject

class GetMovie
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<Movie, GetMovie.Params>(){
    override suspend fun run(params: Params): Either<Failure, Movie> =moviesRepository.movies(params.apikey ,params.s)

    data class Params(val apikey:String , val s :String)


}