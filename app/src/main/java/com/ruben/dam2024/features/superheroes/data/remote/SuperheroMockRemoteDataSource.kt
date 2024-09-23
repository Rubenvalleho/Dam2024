package com.ruben.dam2024.features.superheroes.data.remote

import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperheroMockRemoteDataSource {
    fun getSuperheroes(): List<Superhero> {
        return listOf(
            Superhero(
                "Iron Man",
                "Tony Stark",
                "https://cursokotlin.com/wp-content/uploads/2011/07/ironman.jpg"
            ),
            Superhero(
                "Spiderman",
                "Peter Parker",
                "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"
            ),
            Superhero(
                "Thor",
                "Thor Odinson",
                "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"
            )
        )
    }

    fun getSuperhero(id: String): Superhero? {
        return getSuperheroes().firstOrNull { superhero ->
            superhero.id == id
        }
    }
}