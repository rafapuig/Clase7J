package es.rafapuig.movieapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.rafapuig.movieapp.R
import es.rafapuig.movieapp.data.network.model.Movie
import es.rafapuig.movieapp.databinding.ViewMovieItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    class MovieViewHolder(private val binding: ViewMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val imageBaseUrl = "https://image.tmdb.org/t/p/w185/"

        fun bind(movie: Movie) {
            binding.movieTitle.text = movie.title

            Glide.with(binding.moviePoster)
                .load("$imageBaseUrl${movie.posterPath}")
                .placeholder(R.mipmap.ic_launcher)
                .fitCenter()
                .into(binding.moviePoster)

        }

    }

    private val movies = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewMovieItemBinding.inflate(layoutInflater)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun addMovies(movieList: List<Movie>) {
        movies.addAll(movieList)
        notifyItemRangeInserted(0,movieList.size)
    }

}