package com.example.android_sample.features.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.android_sample.core.const.Const
import com.example.android_sample.core.platform.BaseViewModel
import com.example.android_sample.features.GetMovie
import com.example.android_sample.features.Movie
import com.example.android_sample.features.MovieView
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

class MoviesViewModel
@Inject constructor(private val getMovie: GetMovie) : BaseViewModel() {

    var movies: MutableLiveData<MovieView> = MutableLiveData()

    fun loadMovies() = getMovie(
        GetMovie.Params(
            Const.ServiceType.PARAMETER_API_KEY,
            Const.ServiceType.PARAMETER_TITEL
        )
    ) {
        it.fold(::handleFailure, ::handleMovieDetails)
    }

    private fun handleMovieDetails(movies: Movie) {
        this.movies.postValue(MovieView(movies.totalResults, movies.Search, movies.totalResults))
    }
}
