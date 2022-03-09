package com.example.data.model.mapper

import com.example.data.model.ApiMapper
import com.example.data.model.entities.MokyResponse
import com.example.domain.model.MovieDomain

class MovieApiMapper : ApiMapper<MokyResponse, MovieDomain> {

    override fun mapToListDomain(apiEntity: List<MokyResponse>): List<MovieDomain> {
        val data = mutableListOf<MovieDomain>()
        apiEntity.forEach {
            data.add(MovieDomain(movieName = it.movieName, movieGenre = it.movieGenre))
        }
        return data.toList()
    }

}