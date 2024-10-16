package com.ruben.dam2024.features.superheroes.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ruben.dam2024.R
import com.ruben.dam2024.app.extensions.loadUrl
import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperheroDetailActivity : AppCompatActivity() {
    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var superheroViewModel: SuperheroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)

        superheroFactory = SuperheroFactory(this)
        superheroViewModel = superheroFactory.buildDetailViewModel()

        setupObserver()

        getSuperheroId()?.let { superheroId ->
            superheroViewModel.viewCreated(superheroId)
        }
    }

    private fun getSuperheroId(): String? {
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }

    private fun binData(superhero: Superhero) {
        val imageView = findViewById<ImageView>(R.id.superhero_image1)
        //imageView.loadUrl(superhero.photoUrl)
    }

    companion object {
        val KEY_SUPERHERO_ID = "key_movie_id"

        fun getIntent(context: Context, superheroId: String): Intent {
            val intent = Intent(context, SuperheroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHERO_ID, superheroId)
            return intent
        }
    }

    private fun setupObserver() {
        val superheroObserver = Observer<SuperheroDetailViewModel.UiState> { uiState ->
            uiState.superhero?.let {
                binData(it)
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
        superheroViewModel.uiState.observe(this, superheroObserver)
    }

}