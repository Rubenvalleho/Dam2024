package com.ruben.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ruben.dam2024.R
import com.ruben.dam2024.features.movies.domain.Movie

class MoviesActivity : AppCompatActivity() {

    private val movieFactory: MovieFactory = MovieFactory()
    private val viewModel = movieFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movies = viewModel.viewCreated()
        val movie = viewModel.movieSelected("1")
        Log.d("@dev", movies.toString())
        Log.d("@dev", movie.toString())
        bindDate(movies)
    }

    override fun onStart() {
        super.onStart()
        Log.d("@dev", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("@dev", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("@dev", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("@dev", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("@dev", "onDestroy")
    }

    private fun bindDate(movies: List<Movie>) {
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            val movie1: Movie? = viewModel.movieSelected(movies[0].id)
            movie1?.let { movie ->
                Log.d("@dev", "Pelicula seleccionada: ${movie.title}")
            }
        }
        // val textView1 = findViewById<LinearLayout>(R.id.layout_1)

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            val movie2: Movie? = viewModel.movieSelected(movies[1].id)
            movie2?.let { movie ->
                Log.d("@dev", "Pelicula seleccionada: ${movie.title}")
            }
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            val movie3: Movie? = viewModel.movieSelected(movies[2].id)
            movie3?.let { movie ->
                Log.d("@dev", "Pelicula seleccionada: ${movie.title}")
            }
        }

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_id_4).text = movies[3].title
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            val movie4: Movie? = viewModel.movieSelected(movies[3].id)
            movie4?.let { movie ->
                Log.d("@dev", "Pelicula seleccionada: ${movie.title}")
            }
        }
    }
}