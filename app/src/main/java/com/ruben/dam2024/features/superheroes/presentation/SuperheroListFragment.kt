package com.ruben.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ruben.dam2024.R
import com.ruben.dam2024.app.extensions.loadUrl
import com.ruben.dam2024.databinding.FragmentSuperheroListBinding
import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperheroListFragment : Fragment() {

    //  private val superheroFactory: SuperheroFactory = SuperheroFactory(this)
    //  private val viewModel = superheroFactory.buildViewModel()

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperheroListViewModel

    private var _binding: FragmentSuperheroListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superheroFactory = SuperheroFactory(requireContext())
        viewModel = superheroFactory.getSuperheroListViewModel()

        setUpObserver()

        viewModel.loadSuperheroes()
    }


    private fun bindData(superheroes: List<Superhero>) {
        binding.superheroImage1.loadUrl(superheroes[0].photoUrl)
        binding.superheroImage1.setOnClickListener {
            navigateToSuperheroDetail(superheroes[0].id)
        }
        binding.superheroName1.text = superheroes[0].name
        binding.superheroImage2.loadUrl(superheroes[1].photoUrl)
        binding.superheroImage2.setOnClickListener {
            navigateToSuperheroDetail(superheroes[1].id)
        }
        binding.superheroName2.text = superheroes[1].name
        binding.superheroImage3.loadUrl(superheroes[2].photoUrl)
        binding.superheroImage3.setOnClickListener {
            navigateToSuperheroDetail(superheroes[2].id)
        }
        binding.superheroName3.text = superheroes[2].name
    }

    private fun setUpObserver() {
        val superheroObserver = Observer<SuperheroListViewModel.UiState> { uiState ->
            uiState.superheroes?.let {
                bindData(it)
            }

            uiState.errorApp?.let {
                //Pinto el error
            } ?: run {
                //Oculto el error
            }

            if (uiState.isLoading) {
                //Muestro cargando
            } else {
                //Oculto cargando
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, superheroObserver)
    }

    /*private fun testXml() {
        val xmlDataSource = SuperheroXmlLocalDataSource(this)
        val superhero = viewModel.superheroSelected("1")
        superhero?.let {
            xmlDataSource.save(it)
        }

        val superheroSaved = xmlDataSource.findById("1")
        Log.d("@dev", superheroSaved.toString())
    }*/

    private fun navigateToSuperheroDetail(superheroId: String) {
        findNavController().navigate(
            SuperheroListFragmentDirections.actionSuperheroListFragmentToSuperheroDetailFragment(
                superheroId
            )
        )
    }
}