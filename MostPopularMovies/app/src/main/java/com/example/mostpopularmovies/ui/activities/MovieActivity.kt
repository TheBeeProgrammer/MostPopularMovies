package com.example.mostpopularmovies.ui.activities

import ViewPagerAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mostpopularmovies.R
import com.example.mostpopularmovies.databinding.ActivityMovieBinding
import com.example.mostpopularmovies.ui.fragments.MovieFragment
import com.example.mostpopularmovies.ui.fragments.MoviesAndSeriesFragment
import com.example.mostpopularmovies.ui.fragments.SeriesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        setupViewPagerAdapter()

    }

    private fun setupViewPagerAdapter() {
        binding.tlMovies.setupWithViewPager(binding.pager)
        val vpAdapter = ViewPagerAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ).apply {
            addFragment(MoviesAndSeriesFragment.newinstance(), "Movies & Series")
            addFragment(MovieFragment.newInstance(), "Movies")
            addFragment(SeriesFragment.newInstance(), "Series")
        }
        binding.pager.adapter = vpAdapter
    }


}