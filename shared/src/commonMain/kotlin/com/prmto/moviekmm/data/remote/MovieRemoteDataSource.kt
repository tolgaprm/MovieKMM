package com.prmto.moviekmm.data.remote

import com.prmto.moviekmm.util.Dispatcher
import kotlinx.coroutines.withContext

internal class MovieRemoteDataSource(
    private val apiService: MovieService,
    private val dispatcher: Dispatcher
) {
    suspend fun getMovies(page: Int) = withContext(dispatcher.io) {
        apiService.getMovies(page = page).results
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io) {
        apiService.getMovieDetail(movieId = movieId)
    }
}