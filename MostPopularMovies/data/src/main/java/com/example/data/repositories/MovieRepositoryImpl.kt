package com.example.data.repositories

import com.example.data.api.MokyApi
import com.example.data.model.mapper.MovieApiMapper
import com.example.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MokyApi,
    private val apiListPriceMapper: MovieApiMapper
) : MovieRepository {

    override fun getListMovie() = api.getMovies().map {
        apiListPriceMapper.mapToListDomain(it)

    }
}