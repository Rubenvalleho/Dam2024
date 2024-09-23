package com.ruben.dam2024.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroUseCase
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroesUseCase
import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperheroViewModel(private val getSuperheroesUseCase: GetSuperheroesUseCase, private val getSuperheroUseCase: GetSuperheroUseCase): ViewModel() {
      fun viewCreated(): List<Superhero> {
          return getSuperheroesUseCase.invoke()
      }

    fun superheroSelected(id: String): Superhero? {
        return getSuperheroUseCase.invoke(id)
    }
}