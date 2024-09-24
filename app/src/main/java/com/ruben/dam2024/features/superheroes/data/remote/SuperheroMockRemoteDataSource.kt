package com.ruben.dam2024.features.superheroes.data.remote

import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperheroMockRemoteDataSource {

    val superheroes: List<Superhero> = listOf(
        Superhero(
        "1",
        "Iron Man",
        "https://cursokotlin.com/wp-content/uploads/2011/07/ironman.jpg"
        ),
        Superhero(
            "2",
            "Spiderman",
            "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"
        ),
        Superhero(
            "2",
            "Batman",
            "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"
        )
    )

    fun fetchSuperheroes(): List<Superhero> {
        return superheroes
    }

    fun getSuperhero(id: String): Superhero? {
        return fetchSuperheroes().firstOrNull { superhero ->
            superhero.id == id
        }
    }
}