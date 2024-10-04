package com.ruben.dam2024.features.movies.data.remote

import com.ruben.dam2024.features.movies.domain.Movie

class MovieMockRemoteDataSource {

    private val movies: List<Movie> = listOf(
        Movie("1", "El señor de los anillos", ""),
        Movie("2", "Pelicula 2", "https://www.google.com"),
        Movie("3", "Pelicula 3", "https://www.google.com"),
        Movie(title = "Titulo 4", id = "4", poster = "https://www.google.com")
    )

    fun getMovies(): List<Movie> {
        return movies
    }

    fun getMovie(id: String): Movie? {
        return getMovies().firstOrNull { movie -> //Renombra el it por movie
            // it.id == id
            movie.id == id }
    }
}