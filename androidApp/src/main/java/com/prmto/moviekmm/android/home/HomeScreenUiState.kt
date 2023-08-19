package com.prmto.moviekmm.android.home

import com.prmto.moviekmm.domain.model.Movie

data class HomeScreenUiState(
    val loading: Boolean = false,
    val refreshing: Boolean = false,
    val movies: List<Movie> = listOf(),
    val errorMessage: String? = null,
    val loadFinished: Boolean = false
)