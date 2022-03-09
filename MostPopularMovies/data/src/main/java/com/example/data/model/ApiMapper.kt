package com.example.data.model

import com.example.data.model.entities.MoviesResponse

interface ApiMapper<E, D> {
    fun mapToListDomain(apiEntity: MoviesResponse): List<D>
}