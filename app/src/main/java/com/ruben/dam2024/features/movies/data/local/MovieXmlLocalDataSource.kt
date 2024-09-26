package com.ruben.dam2024.features.movies.data.local

import android.content.Context
import com.ruben.dam2024.R
import com.ruben.dam2024.features.movies.domain.Movie

class MovieXmlLocalDataSource(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )

    fun saveMovie(movie: Movie) {
        val editor = sharedPreferences.edit()
        editor.putString("id", movie.id)
        editor.putString("title", movie.title)
        editor.putString("poster", movie.poster)
        editor.apply()
    }

    fun findMovie(): Movie {
        val id = sharedPreferences.getString("id", "")
        val title = sharedPreferences.getString("title", "")
        val poster = sharedPreferences.getString("poster", "")
        return Movie(id!!, title!!, poster!!)
    }
}