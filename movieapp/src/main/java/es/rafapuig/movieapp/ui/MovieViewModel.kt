package es.rafapuig.movieapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import es.rafapuig.movieapp.MovieApplication
import es.rafapuig.movieapp.data.MovieRepository
import es.rafapuig.movieapp.data.network.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(val movieRepository: MovieRepository) : ViewModel() {

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean> = _loading

    private val _movies = MutableLiveData<List<Movie>>()
    val movies : LiveData<List<Movie>> = _movies

    fun fetchMovies() {
        _loading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            _movies.postValue(movieRepository.fetchMovies())
            _loading.postValue(false)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as MovieApplication
                MovieViewModel(application.movieRepository)
            }
        }
    }

}