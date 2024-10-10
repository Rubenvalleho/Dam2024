package com.ruben.dam2024.features.superheroes.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.ruben.dam2024.R
import com.ruben.dam2024.app.extensions.loadUrl
import com.ruben.dam2024.databinding.FragmentSuperheroDetailBinding
import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperheroDetailFragment : Fragment() {
    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var superheroViewModel: SuperheroDetailViewModel

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding = _binding!!

    private val superheroArgs: SuperheroDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superheroArgs.superheroId
    }

    /*private fun getSuperheroId(): String? {
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }*/

    private fun binData(superhero: Superhero) {
        binding.apply {
            superheroImage1.loadUrl(superhero.photoUrl)
            superheroName1.text = superhero.name
        }
    }

    companion object {
        val KEY_SUPERHERO_ID = "key_movie_id"

        fun getIntent(context: Context, superheroId: String): Intent {
            val intent = Intent(context, SuperheroDetailFragment::class.java)
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
            } ?: run {

            }
        }
        superheroViewModel.uiState.observe(this, superheroObserver)
    }
}