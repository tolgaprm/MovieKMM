package com.prmto.moviekmm.data.mapper

import com.prmto.moviekmm.data.remote.MovieRemote
import com.prmto.moviekmm.domain.model.Movie

internal fun MovieRemote.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        description = overview,
        imageUrl = getImageUrl(posterPath),
        releaseDate = releaseDate
    )
}

private fun getImageUrl(posterImage: String) = "https://image.tmdb.org/t/p/w500/$posterImage"