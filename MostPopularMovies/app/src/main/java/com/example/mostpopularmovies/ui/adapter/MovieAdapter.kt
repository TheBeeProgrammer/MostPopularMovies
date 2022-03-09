package com.example.mostpopularmovies.ui.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.MovieDomain
import com.example.mostpopularmovies.ui.viewholder.MovieViewholder

class MovieAdapter :
    RecyclerView.Adapter<MovieViewholder>() {

    private val items = mutableListOf(MovieDomain())

    @SuppressLint("NotifyDataSetChanged")
    fun addData(movieList: List<MovieDomain>?) {
        items.clear()
        if (movieList != null && !movieList.isNullOrEmpty()) {
            items.addAll(movieList)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewholder.from(parent)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MovieViewholder, position: Int) {
        holder.bind(items[position])
    }
}