package com.ruben.dam2024.features.superheroes.presentation

import com.ruben.dam2024.features.superheroes.data.SuperheroDataRepository
import com.ruben.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroUseCase
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroesUseCase

class SuperheroFactory {

    private val superheroMockRemoteDataSource = SuperheroMockRemoteDataSource()
    private val superheroDataRepository = SuperheroDataRepository(superheroMockRemoteDataSource)
    private val getSuperheroesUseCase = GetSuperheroesUseCase(superheroDataRepository)
    private val getSuperheroUseCase = GetSuperheroUseCase(superheroDataRepository)

    fun buildViewModel(): SuperheroViewModel {
        return SuperheroViewModel(getSuperheroesUseCase, getSuperheroUseCase)
    }
}