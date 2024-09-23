package com.ruben.dam2024.features.superheroes.presentation

import com.ruben.dam2024.features.superheroes.data.SuperheroDataRepository
import com.ruben.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroUseCase
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroesUseCase

class SuperheroFactory {
    fun buildViewModel(): SuperheroViewModel {
        return SuperheroViewModel(
            GetSuperheroesUseCase(SuperheroDataRepository(SuperheroMockRemoteDataSource())),
            GetSuperheroUseCase(SuperheroDataRepository(SuperheroMockRemoteDataSource()))
        )
    }
}