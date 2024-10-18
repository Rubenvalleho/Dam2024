package com.ruben.dam2024.features.superheroes.data.remote

import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperheroApiRemoteDataSource(private val superheroService: SuperheroService) {

    suspend fun getSuperheroes(): List<Superhero> {
        val response = superheroService.requestSuperheroes()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            // Manejar el error
            return emptyList()
        }
    }

    suspend fun getSuperhero(id: String): Superhero {
        return superheroService.getSuperhero(id)
    }


}