package com.example.core.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.reactivex.disposables.CompositeDisposable

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ViewmodelModule {

    companion object {
        @Provides
        fun provideCompositeDisposable() = CompositeDisposable()
    }
}