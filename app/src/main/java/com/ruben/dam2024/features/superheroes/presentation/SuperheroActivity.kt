package com.ruben.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.dam2024.R
import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperheroActivity : AppCompatActivity() {

    private val superheroFactory: SuperheroFactory = SuperheroFactory()
    private val viewModel = superheroFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val superheroes = viewModel.viewCreated()
        val superhero = viewModel.superheroSelected("Thor")
        Log.d("@dev", superheroes.toString())
        Log.d("@dev", superhero.toString())
        bindDate(superheroes)
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

    private fun bindDate(superheroes: List<Superhero>) {
        findViewById<TextView>(R.id.superhero_id_1).text = superheroes[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = superheroes[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            val superhero1: Superhero? = viewModel.superheroSelected(superheroes[0].id)
            superhero1?.let {
                Log.d("@dev", "El superheroe selecionado es: ${it.name}")
            }
        }
    }
}