package com.prmto.moviekmm.data.repository

import com.prmto.moviekmm.data.mapper.toMovie
import com.prmto.moviekmm.data.remote.MovieRemoteDataSource
import com.prmto.moviekmm.domain.model.Movie
import com.prmto.moviekmm.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
        return movieRemoteDataSource.getMovies(page = page).map { it.toMovie() }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return movieRemoteDataSource.getMovie(movieId = movieId).toMovie()
    }
}