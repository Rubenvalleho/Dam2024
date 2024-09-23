package com.ruben.dam2024.features.movies.data

import com.ruben.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import com.ruben.dam2024.features.movies.domain.Movie
import com.ruben.dam2024.features.movies.domain.MovieRepository

class MovieDataRepository (private val mockRemoteDataSource: MovieMockRemoteDataSource) : MovieRepository{

    override fun getMovies(): List<Movie> {
        return mockRemoteDataSource.getMovies()
    }

    override fun getMovie(id: String): Movie? {
        return mockRemoteDataSource.getMovie(id)
    }

}