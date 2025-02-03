package es.rafapuig.movieapp.data.network.model

import com.squareup.moshi.Json

data class Movie(
    val title: String = "",
    @Json(name = "original_title") val originalTitle: String = "",
    @Json(name = "poster_path") val posterPath: String = ""
)
