package com.ruben.dam2024.features.superheroes.domain

class GetSuperheroesUseCase(private val superheroRepository: SuperheroRepository) {
    operator fun invoke(): List<Superhero> {
        return superheroRepository.getSuperheroes()
    }
}