package com.example.mostpopularmovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.Event
import com.example.core.extensions.createExceptionHandler
import com.example.domain.model.MovieDomain
import com.example.domain.usecases.MovieUseCase
import com.example.logger.TimberLogger
import com.example.mostpopularmovies.model.MovieViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {

    val state: LiveData<MovieViewState>
        get() = _state

    private val _state: MutableLiveData<MovieViewState> = MutableLiveData()

    private var runningJobs = mutableListOf<Job>()


    init {
        _state.value = MovieViewState()
        getMovies()
    }

    fun getMovies() {
        val exceptionHandler = viewModelScope.createExceptionHandler("Error") { onFailure(it) }
        viewModelScope.launch(exceptionHandler) {
            movieUseCase().toObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { runningJobs.map { it.cancel() } }
                .subscribe(
                    { onGetMoviesResult(it) },
                    { onFailure(it) }
                )
                .addTo(compositeDisposable)
        }
    }

    private fun onGetMoviesResult(movieDomain: List<MovieDomain>?) {
        TimberLogger.d(movieDomain.toString())
        bindMovies(movieDomain)

    }

    private fun onFailure(throwable: Throwable) {
        TimberLogger.d(throwable.message.toString())
        _state.value =
            state.value!!.copy(
                isLoading = false,
                failure = Event(throwable),
                isSuccess = false
            )
    }

    private fun bindMovies(movieDomain: List<MovieDomain>?) {
        _state.value = state.value!!.copy(
            isLoading = false,
            isSuccess = true,
            movieDomain = movieDomain
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}