package com.ruben.dam2024.features.movies.data

import com.ruben.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import com.ruben.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import com.ruben.dam2024.features.movies.domain.Movie
import com.ruben.dam2024.features.movies.domain.MovieRepository

class MovieDataRepository(
    private val mockRemoteDataSource: MovieMockRemoteDataSource,
    private val local: MovieXmlLocalDataSource
) : MovieRepository {

    override fun getMovies(): List<Movie> {
        val moviesFromLocal = local.findAll()
        if (moviesFromLocal.isEmpty()) {
            val moviesFromRemote = mockRemoteDataSource.getMovies()
            local.saveAll(moviesFromRemote)
            return moviesFromRemote
        } else {
            return moviesFromLocal
        }
    }

    override fun getMovie(id: String): Movie? {
        val movieFromLocal = local.findById(id)
        if (movieFromLocal == null) {
            val movieFromRemote = mockRemoteDataSource.getMovie(id)
            movieFromRemote?.let {
                local.saveMovie(it)
                return it
            }
        }
        return movieFromLocal
    }

}