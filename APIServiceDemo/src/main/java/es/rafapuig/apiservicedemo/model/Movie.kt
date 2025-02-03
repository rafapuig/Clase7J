package es.rafapuig.apiservicedemo.model

import com.squareup.moshi.Json

data class Movie (
    val title: String = "",
    @Json(name = "original_title") val originalTitle: String = ""
)
