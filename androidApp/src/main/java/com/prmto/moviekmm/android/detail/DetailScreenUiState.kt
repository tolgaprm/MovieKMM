package com.prmto.moviekmm.android.detail

import com.prmto.moviekmm.domain.model.Movie

data class DetailScreenUiState(
    val loading: Boolean = false,
    val movie: Movie? = null,
    val errorMessage: String? = null
)