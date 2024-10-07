package com.ruben.dam2024.features.movies.data.remote

import com.ruben.dam2024.features.movies.domain.Movie

class MovieMockRemoteDataSource {

    private val movies: List<Movie> = listOf(
        Movie("1", " El club de la lucha", "https://pics.filmaffinity.com/fight_club-320750671-large.jpg"),
        Movie("2", " Erase una vez en Hollywood", "https://pics.filmaffinity.com/once_upon_a_time_in_hollywood-735160977-large.jpg"),
        Movie("3", " Los odiosos ocho", "https://pics.filmaffinity.com/the_hateful_eight-549467052-large.jpg"),
        Movie(title = " La la land", id = "4", poster = "https://pics.filmaffinity.com/la_la_land-262021831-large.jpg")
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