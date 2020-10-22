package com.example.android_sample.features

import com.example.android_sample.core.extension.empty

data class MovieEntity(
    val Response: String,
    val Search: List<SearchModel>,
    val totalResults: String
) {

    fun toMovie() =
        Movie(Response, Search, totalResults)

    companion object {
        fun empty() = MovieEntity(String.empty(), emptyList(), String.empty())
    }
}