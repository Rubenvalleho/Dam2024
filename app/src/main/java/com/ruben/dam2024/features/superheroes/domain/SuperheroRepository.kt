package com.ruben.dam2024.features.superheroes.domain

interface SuperheroRepository {
    suspend fun getSuperheroes(): List<Superhero>
    suspend fun getSuperhero(id: String): Superhero?
}