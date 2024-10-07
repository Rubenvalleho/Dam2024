package com.ruben.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.ruben.dam2024.R
import com.ruben.dam2024.app.extensions.loadUrl
import com.ruben.dam2024.features.movies.domain.Movie

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildMovieDetailViewModel()

        setupObserver()

        getMovieId()?.let { movieId ->
            viewModel.viewCreated(movieId)
        }

/*        getMovieId()?.let { movieId ->
            viewModel.viewCreated(movieId)?.let { movie ->
                bindData(movie)
            }
        }
*/

    }

    private fun getMovieId(): String? {
        return intent.getStringExtra(KEY_MOVIE_ID)
    }

    private fun bindData(movie: Movie){
        //findViewById<TextView>(R.id.nombre_pelicula).text = movie.title
        val imageView = findViewById<ImageView>(R.id.poster)
        imageView.loadUrl(movie.poster)
    }

    companion object {
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }

    private fun setupObserver() {
        val movieObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
            uiState.movie?.let {
                bindData(it)
            }

            if (uiState.isLoading) {
                //Muestro el cargando...
            } else {
                //oculto el cargando...
            }

            uiState.errorApp?.let {
                //showError(it)
            }
        }
        viewModel.uiState.observe(this, movieObserver)
    }
}
