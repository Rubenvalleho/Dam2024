package com.ruben.dam2024.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroUseCase
import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperheroDetailViewModel(
    private val getSuperheroUseCase: GetSuperheroUseCase
) : ViewModel() {

    fun viewCreated(superheroId: String): Superhero? {
        return getSuperheroUseCase.invoke(superheroId)
    }
}