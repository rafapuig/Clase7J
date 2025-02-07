package es.rafapuig.movieapp.data

import es.rafapuig.movieapp.data.network.api.MovieService
import es.rafapuig.movieapp.domain.MovieRepository
import es.rafapuig.movieapp.domain.model.Movie

class MovieRepositoryImpl(private val movieService: MovieService) : MovieRepository {

    override suspend fun fetchMovies(): List<Movie> {
        val moviesResponse = movieService.getMovies()
        return moviesResponse.results.map { movie -> movie.toDomain() }
    }

}