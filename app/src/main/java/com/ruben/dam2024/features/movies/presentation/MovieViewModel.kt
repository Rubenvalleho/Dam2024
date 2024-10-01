package com.ruben.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import com.ruben.dam2024.features.movies.domain.GetMovieUseCase
import com.ruben.dam2024.features.movies.domain.GetMoviesUseCase
import com.ruben.dam2024.features.movies.domain.Movie

class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {
    //Patron Model-View-View-Model MVVM

    fun viewCreated(movieId: String): Movie? {
        return getMovieUseCase.invoke(movieId)
    }
}