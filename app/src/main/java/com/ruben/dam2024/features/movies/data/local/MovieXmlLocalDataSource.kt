package com.ruben.dam2024.features.movies.data.local

import android.content.Context
import com.google.gson.Gson
import com.ruben.dam2024.R
import com.ruben.dam2024.features.movies.domain.Movie

class MovieXmlLocalDataSource(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun saveMovie(movie: Movie) {
        /* Estilo Java
        val editor = sharedPreferences.edit()
        editor.putString("id", movie.id)
        editor.putString("title", movie.title)
        editor.putString("poster", movie.poster)
        editor.apply()
        */

        //Estilo kotlin
        sharedPreferences.edit().apply() {
            putString("id", movie.id)
            putString("title", movie.title)
            putString("poster", movie.poster)
            apply()
        }
    }

    fun saveAll(movies: List<Movie>) {
        val editor = sharedPreferences.edit()
        movies.forEach { movie ->
            editor.putString(movie.id, gson.toJson(movie))
        }
        editor.apply()
    }

    fun findAll(): List<Movie> {
        val movies = mutableListOf<Movie>()
        val mapMovies = sharedPreferences.all //Esto es un cast en kotlin = as Map<String, String>
        mapMovies.values.forEach { jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }

    fun findMovie(): Movie {
        /*
        val id = sharedPreferences.getString("id", "")
        val title = sharedPreferences.getString("title", "")
        val poster = sharedPreferences.getString("poster", "")
        return Movie(id!!, title!!, poster!!)
        */

        sharedPreferences.apply {
            return Movie(
                getString("id", "")!!,
                getString("title", "")!!,
                getString("poster", "")!!
            )
        }
    }

    fun delete() {
        sharedPreferences.edit().clear().apply()
    }

}