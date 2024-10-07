package com.ruben.dam2024.features.movies.presentation

import android.content.Context
import com.ruben.dam2024.features.movies.data.MovieDataRepository
import com.ruben.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import com.ruben.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import com.ruben.dam2024.features.movies.domain.GetMovieUseCase
import com.ruben.dam2024.features.movies.domain.GetMoviesUseCase

class MovieFactory(private val context: Context) {

    private val movieMockRemote = MovieMockRemoteDataSource()
    private val movieLocal = MovieXmlLocalDataSource(context)
    private val movieDataRepository = MovieDataRepository(movieMockRemote, movieLocal)
    private val getMovieUseCase = GetMovieUseCase(movieDataRepository)
    private val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)

    fun buildViewModel(): MoviesViewModel {
        return MoviesViewModel(getMoviesUseCase)
    }

    fun buildMovieDetailViewModel(): MovieDetailViewModel {
        return MovieDetailViewModel(getMovieUseCase)
    }
}