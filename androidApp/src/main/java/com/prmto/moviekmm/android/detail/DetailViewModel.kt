package com.prmto.moviekmm.android.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prmto.moviekmm.domain.usecase.GetMovieUseCase
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var uiState by mutableStateOf(DetailScreenUiState())
        private set

    init {
        savedStateHandle.get<Int>("movieId")?.let { movieId ->
            loadMovie(movieId)
        }
    }

    private fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)
            uiState = try {
                val movie = getMovieUseCase(movieId)
                uiState.copy(loading = false, movie = movie)
            } catch (e: Exception) {
                uiState.copy(loading = false, errorMessage = "Could not find movie")
            }
        }
    }
}