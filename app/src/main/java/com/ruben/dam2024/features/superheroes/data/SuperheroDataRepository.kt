package com.ruben.dam2024.features.superheroes.data

import com.ruben.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import com.ruben.dam2024.features.superheroes.domain.Superhero
import com.ruben.dam2024.features.superheroes.domain.SuperheroRepository

class SuperheroDataRepository (
    private val superheromockRemoteDataSource: SuperheroMockRemoteDataSource): SuperheroRepository{
    override fun getSuperheroes(): List<Superhero> {
        return superheromockRemoteDataSource.getSuperheroes()
    }

    override fun getSuperhero(id: String): Superhero? {
        return superheromockRemoteDataSource.getSuperhero(id)
    }
}