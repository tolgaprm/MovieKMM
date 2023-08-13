package com.prmto.moviekmm.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MovieService : KtorApi() {
    suspend fun getMovies(page: Int): MoviesResponse = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getMovieDetail(movieId: Int): MovieRemote = client.get {
        pathUrl("movie/$movieId")
    }.body()
}