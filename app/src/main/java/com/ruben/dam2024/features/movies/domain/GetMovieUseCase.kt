package com.ruben.dam2024.features.movies.domain

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    fun invoke(id: String): Movie? {
        return movieRepository.getMovie(id)
    }
}