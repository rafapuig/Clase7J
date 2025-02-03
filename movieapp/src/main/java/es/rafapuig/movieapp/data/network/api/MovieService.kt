package es.rafapuig.movieapp.data.network.api

import es.rafapuig.movieapp.data.network.model.MoviesResponse
import retrofit2.http.GET

interface MovieService {

    @GET("movie/now_playing")
    suspend fun getMovies() : MoviesResponse
}