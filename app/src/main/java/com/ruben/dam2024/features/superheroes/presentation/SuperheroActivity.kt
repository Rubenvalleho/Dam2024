package com.ruben.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.dam2024.R

class SuperheroActivity : AppCompatActivity() {

    private val superheroFactory: SuperheroFactory = SuperheroFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val viewModel = superheroFactory.buildViewModel()
        val superheroes = viewModel.viewCreated()
        val superhero = viewModel.superheroSelected("Thor")
        Log.d("@dev", superheroes.toString())
        Log.d("@dev", superhero.toString())
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
}