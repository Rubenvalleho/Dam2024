package com.ruben.dam2024.features.superheroes.presentation

import com.ruben.dam2024.features.superheroes.data.SuperheroDataRepository
import com.ruben.dam2024.features.superheroes.data.local.SuperheroXmlLocalDataSource
import com.ruben.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroUseCase
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroesUseCase
import android.content.Context

class SuperheroFactory(private val context: Context) {

    private val superheroMockRemoteDataSource = SuperheroMockRemoteDataSource()
    private val superheroXmlLocalDataSource = SuperheroXmlLocalDataSource(context)
    private val superheroDataRepository = SuperheroDataRepository(superheroMockRemoteDataSource, superheroXmlLocalDataSource)
    private val getSuperheroesUseCase = GetSuperheroesUseCase(superheroDataRepository)
    private val getSuperheroUseCase = GetSuperheroUseCase(superheroDataRepository)

    fun buildViewModel(): SuperheroViewModel {
        return SuperheroViewModel(getSuperheroesUseCase, getSuperheroUseCase)
    }
}