package com.ruben.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ruben.dam2024.R
import com.ruben.dam2024.app.domain.ErrorApp
import com.ruben.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import com.ruben.dam2024.features.movies.domain.Movie

class MoviesActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildViewModel()

        val movies = viewModel.viewCreated()

        setupObserver()
        viewModel.viewCreated()

        //val movie = viewModel.movieSelected("1")
        //Log.d("@dev", movies.toString())
        //Log.d("@dev", movie.toString())
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

    private fun getMovies() {
        viewModel.viewCreated()
    }
    /*private fun testXml() {
        val xmlDataSource = MovieXmlLocalDataSource(this)
        val movie = viewModel.movieSelected("1")
        movie?.let {
            xmlDataSource.saveMovie(it)
        }

        val movieSaved = xmlDataSource.findMovie()
        Log.d("@dev", movieSaved.toString())

        xmlDataSource.delete()
    }*/

    /*private fun testListXml() {
        val movies = viewModel.viewCreated()
        val xmlDataSource = MovieXmlLocalDataSource(this)
        xmlDataSource.saveAll(movies)

        val moviesSaved = xmlDataSource.findAll()
        Log.d("@dev", moviesSaved.toString())
    }*/

    private fun setupObserver() {
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
                bindData(it)
            }

            uiState.errorApp?.let {
                //Muestro el error
            }

            if (uiState.isLoading) {
                //Muestro el cargando...
            } else {
                //oculto el cargando...
            }
        }

        viewModel.uiState.observe(this, movieObserver)
    }

    private fun navigateToMovieDetail(id: String) {
        startActivity(MovieDetailActivity.getIntent(this, id))
    }

    private fun showError(errorApp: ErrorApp) {
        when (errorApp) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErroApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    private fun bindData(movies: List<Movie>) {
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToMovieDetail(movies[0].id)
        }
        // val textView1 = findViewById<LinearLayout>(R.id.layout_1)

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToMovieDetail(movies[1].id)
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToMovieDetail(movies[2].id)
        }

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_title_4).text = movies[3].title
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            navigateToMovieDetail(movies[3].id)
        }
    }
}