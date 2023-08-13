package com.prmto.moviekmm.data.remote

import kotlinx.serialization.Serializable

@Serializable
internal data class MoviesResponse(
    val results: List<MovieRemote>
)