package com.ruben.dam2024.features.movies.data.remote

import com.ruben.dam2024.features.movies.domain.Movie

class MovieMockRemoteDataSource {
    fun getMovies(): List<Movie> {
        return listOf(
            Movie("1", "El señor de los anillos", "https://www.google.com"),
            Movie("2", "El señor de los anillos", "https://www.google.com"),
            Movie("3", "El señor de los anillos", "https://www.google.com"),
            Movie(title = "Titulo 4", id = "4", poster = "https://www.google.com")
        )
    }

    fun getMovie(id: String): Movie? {
        return getMovies().firstOrNull { movie -> //Renombra el it por movie
            // it.id == id
            movie.id == id }
    }
}