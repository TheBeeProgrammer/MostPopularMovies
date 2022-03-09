package com.example.core.di



import com.example.data.repositories.MovieRepositoryImpl
import com.example.domain.repositories.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.reactivex.disposables.CompositeDisposable

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ViewmodelModule {

    @Binds
    abstract fun bindMovieRepository(repository: MovieRepositoryImpl): MovieRepository

    companion object {
        @Provides
        fun provideCompositeDisposable() = CompositeDisposable()
    }
}