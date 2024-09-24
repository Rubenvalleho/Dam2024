package com.ruben.dam2024.features.superheroes.data

import com.ruben.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import com.ruben.dam2024.features.superheroes.domain.Superhero
import com.ruben.dam2024.features.superheroes.domain.SuperheroRepository

class SuperheroDataRepository (
    private val superheroMockRemoteDataSource: SuperheroMockRemoteDataSource): SuperheroRepository{

    override fun getSuperheroes(): List<Superhero> {
        return superheroMockRemoteDataSource.fetchSuperheroes()
    }

    override fun getSuperhero(id: String): Superhero? {
        return superheroMockRemoteDataSource.getSuperhero(id)
    }
}