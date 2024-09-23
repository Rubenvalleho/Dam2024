package com.ruben.dam2024.features.movies.presentation

import com.ruben.dam2024.features.movies.data.MovieDataRepository
import com.ruben.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import com.ruben.dam2024.features.movies.domain.GetMovieUseCase
import com.ruben.dam2024.features.movies.domain.GetMoviesUseCase

class MovieFactory {

    fun buildViewModel(): MovieViewModel{
        return MovieViewModel(GetMoviesUseCase(MovieDataRepository(MovieMockRemoteDataSource())),
            GetMovieUseCase(MovieDataRepository(MovieMockRemoteDataSource())))
    }
}