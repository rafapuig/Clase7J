package es.rafapuig.apiservicedemo.api

import es.rafapuig.apiservicedemo.model.MoviesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

   /* @Headers(
        "Accept: application/json",
        "Authorization: Bearer $API_TOKEN"
    ) */
    @GET("movie/now_playing")
    fun getMovies() : Call<MoviesResponse>

    @GET("movie/now_playing")
    suspend fun getMoviesAsyncResponse() : Response<MoviesResponse>

    @GET("movie/now_playing")
    suspend fun getMoviesAsync() : MoviesResponse
}