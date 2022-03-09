package com.example.domain.usecases

import com.example.domain.model.MovieDomain
import com.example.domain.repositories.MovieRepository
import io.reactivex.Flowable
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    operator fun invoke(): Flowable<List<MovieDomain>> {
        return movieRepository.getListMovie()
    }
}