package com.ruben.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ruben.dam2024.R
import com.ruben.dam2024.features.superheroes.data.local.SuperheroXmlLocalDataSource
import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperherosActivity : AppCompatActivity() {

  //  private val superheroFactory: SuperheroFactory = SuperheroFactory(this)
  //  private val viewModel = superheroFactory.buildViewModel()

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperherosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)

        superheroFactory = SuperheroFactory(this)
        viewModel = superheroFactory.buildViewModel()


        val superheroes = viewModel.viewCreated()
        //val superhero = viewModel.superheroSelected("1")
        //Log.d("@dev", superheroes.toString())
        //Log.d("@dev", superhero.toString())

        val superheroObserver = Observer<SuperherosViewModel.UiState> { uiState ->
            uiState.superheroes?.let {
                //bindData(it)
            }
        }

        viewModel.uiState.observe(this, superheroObserver)
        //testXml()
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

    /*private fun bindData(superheroes: List<Superhero>) {
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
    }*/
}