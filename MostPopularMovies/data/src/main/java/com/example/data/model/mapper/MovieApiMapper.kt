package com.example.data.model.mapper

import com.example.data.model.ApiMapper
import com.example.data.model.entities.MokyResponse
import com.example.data.model.entities.MoviesResponse
import com.example.domain.model.MovieDomain
import javax.inject.Inject

class MovieApiMapper @Inject constructor() : ApiMapper<MokyResponse, MovieDomain> {

    override fun mapToListDomain(apiEntity: MoviesResponse): List<MovieDomain> {
        val data = mutableListOf<MovieDomain>()
        apiEntity.results.forEach {
            data.add(MovieDomain(movieName = it.movieName, movieGenre = it.movieGenre))
        }
        return data.toList()
    }

}