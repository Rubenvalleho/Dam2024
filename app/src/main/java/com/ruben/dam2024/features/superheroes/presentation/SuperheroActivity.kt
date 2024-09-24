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
        val superhero = viewModel.superheroSelected("3")
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

        findViewById<TextView>(R.id.superhero_id_2).text = superheroes[1].id
        findViewById<TextView>(R.id.superhero_name_2).text = superheroes[1].name
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            val superhero2: Superhero? = viewModel.superheroSelected(superheroes[1].id)
            superhero2?.let {
                Log.d("@dev", "El superheroe selecionado es: ${it.name}")
            }
        }

        findViewById<TextView>(R.id.superhero_id_3).text = superheroes[2].id
        findViewById<TextView>(R.id.superhero_name_3).text = superheroes[2].name
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            val superhero3: Superhero? = viewModel.superheroSelected(superheroes[2].id)
            superhero3?.let {
                Log.d("@dev", "El superheroe selecionado es: ${it.name}")
            }
        }

        findViewById<TextView>(R.id.superhero_id_4).text = superheroes[3].id
        findViewById<TextView>(R.id.superhero_name_4).text = superheroes[3].name
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            val superhero4: Superhero? = viewModel.superheroSelected(superheroes[3].id)
            superhero4?.let {
                Log.d("@dev", "El superheroe selecionado es: ${it.name}")
            }
        }
    }
}