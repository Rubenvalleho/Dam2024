package com.ruben.dam2024.features.superheroes.domain

interface SuperheroRepository {
    fun getSuperheroes(): List<Superhero>
    fun getSuperhero(id: String): Superhero?
}