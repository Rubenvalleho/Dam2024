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
import com.ruben.dam2024.R
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
        findViewById<TextView>(R.id.superhero_id_1).text = superheroes[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = superheroes[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            //val superhero1: Superhero? = viewModel.superheroSelected(superheroes[0].id)
            navigateToSuperheroDetail(superheroes[0].id)
        }

        findViewById<TextView>(R.id.superhero_id_2).text = superheroes[1].id
        findViewById<TextView>(R.id.superhero_name_2).text = superheroes[1].name
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToSuperheroDetail(superheroes[1].id)
        }

        findViewById<TextView>(R.id.superhero_id_3).text = superheroes[2].id
        findViewById<TextView>(R.id.superhero_name_3).text = superheroes[2].name
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToSuperheroDetail(superheroes[2].id)
        }
    }

    private fun setUpObserver() {
        val superheroObserver = Observer<SuperheroListViewModel.UiState> { uiState ->
            uiState.superheroes?.let {
                bindData(it)
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
        startActivity(SuperheroDetailActivity.getIntent(this, superheroId))
    }
}