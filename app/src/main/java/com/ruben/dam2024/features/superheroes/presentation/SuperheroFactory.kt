package com.ruben.dam2024.features.superheroes.presentation

import com.ruben.dam2024.features.superheroes.data.SuperheroDataRepository
import com.ruben.dam2024.features.superheroes.data.local.SuperheroXmlLocalDataSource
import com.ruben.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroUseCase
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroesUseCase
import android.content.Context
import com.ruben.dam2024.app.data.api.ApiClient
import com.ruben.dam2024.features.superheroes.data.remote.SuperheroApiRemoteDataSource
import com.ruben.dam2024.features.superheroes.data.remote.SuperheroService

class SuperheroFactory(private val context: Context) {

    private val superheroApiRemoteDataSource = getSuperheroApiRemoteDataSource()
    private val superheroXmlLocalDataSource = SuperheroXmlLocalDataSource(context)
    private val superheroDataRepository = SuperheroDataRepository(superheroApiRemoteDataSource, superheroXmlLocalDataSource)
    private val getSuperheroesUseCase = GetSuperheroesUseCase(superheroDataRepository)
    private val getSuperheroUseCase = GetSuperheroUseCase(superheroDataRepository)

    fun buildViewModel(): SuperherosViewModel {
        return SuperherosViewModel(getSuperheroesUseCase)
    }

    fun buildDetailViewModel(): SuperheroDetailViewModel {
        return SuperheroDetailViewModel(getSuperheroUseCase)
    }

    fun getSuperheroListViewModel(): SuperheroListViewModel {
        return SuperheroListViewModel(getSuperheroesUseCase)
    }

    private fun getSuperheroApiRemoteDataSource(): SuperheroApiRemoteDataSource {
        val superheroService = ApiClient.provideSuperheroService()
        return SuperheroApiRemoteDataSource(superheroService)
    }
}