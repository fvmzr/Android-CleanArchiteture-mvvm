package com.example.android_sample.features.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.StringRes
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.android_sample.R
import com.example.android_sample.core.exception.Failure
import com.example.android_sample.core.extension.*
import com.example.android_sample.core.platform.BaseFragment
import com.example.android_sample.features.MovieAdapter
import com.example.android_sample.features.MovieView
import com.example.android_sample.features.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

class MoviesFragment : BaseFragment() {
    private lateinit var moviesViewModel: MoviesViewModel

    @Inject
    lateinit var movieAdapter: MovieAdapter

    override fun layoutId() = R.layout.fragment_movies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        moviesViewModel = viewModel(viewModelFactory) {
            observe(movies, ::renderMoviesList)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        loadMoviesList()
    }

    private fun initializeView() {
        movieList.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        movieList.adapter = movieAdapter
    }

    private fun loadMoviesList() {
        emptyView.inVisible()
        movieList.visible()
        showProgress()
        moviesViewModel.loadMovies()
    }

    private fun renderMoviesList(movies: MovieView?) {
        showProgress()
        if (movies != null) {
            movieAdapter.collection = movies.Search
            hideProgress()
        }
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
        }
    }

    private fun renderFailure(@StringRes message: Int) {
        movieList.inVisible()
        emptyView.visible()
        hideProgress()
        notifyWithAction(message, R.string.action_refresh, ::loadMoviesList)
    }
}
