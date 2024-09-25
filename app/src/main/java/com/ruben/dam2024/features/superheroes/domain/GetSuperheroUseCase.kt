package com.ruben.dam2024.features.superheroes.domain

class GetSuperheroUseCase (private val superHeroRepository: SuperheroRepository) {
    operator fun invoke(id: String): Superhero? {
        return superHeroRepository.getSuperhero(id)
    }
}