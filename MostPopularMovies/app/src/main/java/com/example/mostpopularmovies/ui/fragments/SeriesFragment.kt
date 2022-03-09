package com.example.mostpopularmovies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.core.Event
import com.example.data.exceptions.MovieFailed
import com.example.domain.model.MovieDomain
import com.example.mostpopularmovies.R
import com.example.mostpopularmovies.databinding.FragmentMovieBinding
import com.example.mostpopularmovies.databinding.FragmentSeriesBinding
import com.example.mostpopularmovies.model.MovieViewState
import com.example.mostpopularmovies.ui.adapter.MovieAdapter
import com.example.mostpopularmovies.viewmodel.MovieViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.HttpException
import java.io.IOException

@AndroidEntryPoint
class SeriesFragment : Fragment() {

    private val viewModel: MovieViewModel by viewModels()

    lateinit var binding: FragmentSeriesBinding
    private val movieAdapter = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeriesBinding.inflate(inflater)
        binding.adapter = movieAdapter
        observeViewStateUpdates()
        return binding.root
    }

    private fun observeViewStateUpdates() {
        viewModel.state.observe(viewLifecycleOwner) {
            updateScreenState(it)
        }
    }

    private fun updateScreenState(movieViewState: MovieViewState?) {
        configStateView(movieViewState?.movieDomain)
        handleFailures(movieViewState?.failure)
    }

    private fun configStateView(movieDomain: List<MovieDomain>?) {
        movieAdapter.addData(movieDomain?.filter { it.movieGenre == "SERIES" })
    }

    private fun handleFailures(failure: Event<Throwable>?) {
        val unhandledFailure = failure?.getContentIfNotHandled() ?: return
        handleThrowable(unhandledFailure)
    }

    private fun handleThrowable(exception: Throwable) {
        val fallbackMessage = getString(R.string.general_error_message)
        val snackbarMessage = when (exception) {
            is MovieFailed -> fallbackMessage
            is IOException, is HttpException -> exception.message.toString()
            else -> fallbackMessage
        }
        showSnackBar(snackbarMessage)
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }


    companion object {
        fun newInstance() = SeriesFragment()
    }
}