package com.ruben.dam2024.features.superheroes.data

import com.ruben.dam2024.features.superheroes.data.local.SuperheroXmlLocalDataSource
import com.ruben.dam2024.features.superheroes.data.remote.SuperheroApiRemoteDataSource
import com.ruben.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import com.ruben.dam2024.features.superheroes.domain.Superhero
import com.ruben.dam2024.features.superheroes.domain.SuperheroRepository

class SuperheroDataRepository(
    private val remote: SuperheroApiRemoteDataSource,
    private val local: SuperheroXmlLocalDataSource
) : SuperheroRepository {

    override suspend fun getSuperheroes(): List<Superhero> {
        val superheroesFromLocal = local.findAll()
        if (superheroesFromLocal.isEmpty()) {
            val superheroesFromRemote = remote.getSuperheroes()
            local.saveAll(superheroesFromRemote)
            return superheroesFromRemote
        } else {
            return superheroesFromLocal
        }
    }

    override suspend fun getSuperhero(id: String): Superhero? {
        val superheroFromLocal = local.findById(id)
        if (superheroFromLocal == null) {
            val superhero = remote.getSuperhero(id)
            superhero?.let {
                local.save(it)
                return it
            }
        }
        return superheroFromLocal
    }
}