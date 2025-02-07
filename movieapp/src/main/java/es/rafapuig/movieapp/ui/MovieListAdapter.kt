package es.rafapuig.movieapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.rafapuig.movieapp.R
import es.rafapuig.movieapp.databinding.ViewMovieItemBinding
import es.rafapuig.movieapp.domain.model.Movie

class MovieListAdapter(val onItemClick : (Movie) -> Unit) : ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(DIFF_CALLBACK) {


    class MovieViewHolder(
        private val binding: ViewMovieItemBinding,
        val onItemClick : (Movie) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private val imageBaseUrl = "https://image.tmdb.org/t/p/w185/"

        fun bind(movie: Movie) {
            binding.movieTitle.text = movie.title

            Glide.with(binding.moviePoster)
                .load("$imageBaseUrl${movie.posterPath}")
                .placeholder(R.mipmap.ic_launcher)
                .fitCenter()
                .into(binding.moviePoster)

            itemView.setOnClickListener { onItemClick(movie) }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewMovieItemBinding.inflate(layoutInflater)
        return  MovieViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem.id == newItem.id

        }

    }


}