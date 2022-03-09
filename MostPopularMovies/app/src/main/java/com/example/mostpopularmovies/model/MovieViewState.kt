package com.example.mostpopularmovies.model

import com.example.core.Event
import com.example.domain.model.MovieDomain

data class MovieViewState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val failure: Event<Throwable>? = null,
    val movieDomain: List<MovieDomain>? = null
)