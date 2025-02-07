package es.rafapuig.movieapp.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import es.rafapuig.movieapp.databinding.ActivityMainBinding
import es.rafapuig.movieapp.domain.model.Movie

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel: MovieViewModel by viewModels { MovieViewModel.Factory }

    private val movieAdapter by lazy { MovieListAdapter { movie -> onMovieClick(movie) } }

    private fun onMovieClick(movie: Movie) {
        Snackbar
            .make(binding.root, "Has hecho click ... en ${movie.title}", Snackbar.LENGTH_SHORT)
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.movieList.adapter = movieAdapter

        viewModel.fetchMovies()

        viewModel.loading.observe(this) { loading ->
            binding.progressBar.isVisible = loading
        }

        viewModel.movies.observe(this) { movies ->
            movieAdapter.submitList(movies)
        }

    }
}