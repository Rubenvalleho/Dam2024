package com.ruben.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import com.ruben.dam2024.features.movies.domain.GetMovieUseCase
import com.ruben.dam2024.features.movies.domain.GetMoviesUseCase
import com.ruben.dam2024.features.movies.domain.Movie

class MovieViewModel (private val getMoviesUseCase: GetMoviesUseCase,
                      private val getMovieUseCase: GetMovieUseCase) : ViewModel() {
    //Patron Model-View-View-Model MVVM

    fun viewCreated(): List<Movie> {
        return getMoviesUseCase.invoke()
    }

    fun movieSelected(id: String): Movie? {
        return getMovieUseCase.invoke(id)
    }
}