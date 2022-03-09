package com.example.domain.repositories

import com.example.domain.model.MovieDomain
import io.reactivex.Flowable

interface MovieRepository {
    fun getListMovie(): Flowable<List<MovieDomain>>
}