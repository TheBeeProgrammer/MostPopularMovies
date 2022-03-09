package com.example.mostpopularmovies.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.MovieDomain
import com.example.mostpopularmovies.R
import com.example.mostpopularmovies.databinding.ItemsMoviesAndSeriesBinding

class MovieViewholder(private val binding: ItemsMoviesAndSeriesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movieDomain: MovieDomain) {
        binding.movie = movieDomain
        if (movieDomain.movieGenre == "SERIES") binding.ivGenre.setBackgroundResource(R.drawable.ic_serie) else
            binding.ivGenre.setBackgroundResource(R.drawable.ic_movie)
    }

    companion object {
        fun from(
            parent: ViewGroup
        ): MovieViewholder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemsMoviesAndSeriesBinding.inflate(layoutInflater, parent, false)
            return MovieViewholder(binding)
        }
    }
}