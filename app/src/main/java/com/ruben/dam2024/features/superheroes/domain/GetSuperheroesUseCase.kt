package com.ruben.dam2024.features.superheroes.domain

class GetSuperheroesUseCase(private val SuperheroRepository: SuperheroRepository) {
    fun invoke(): List<Superhero> {
        return SuperheroRepository.getSuperheroes()
    }
}