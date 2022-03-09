package com.example.mostpopularmovies

import android.app.Application
import com.example.logger.TimberLogger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initLogger()
    }

    private fun initLogger() {
        TimberLogger.init()
    }
}