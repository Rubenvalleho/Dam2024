package com.ruben.dam2024.features.superheroes.data.remote

import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperheroMockRemoteDataSource {

    private val superheroes: List<Superhero> = listOf(
        Superhero(
        "1",
        "Iron Man",
        "https://static.wikia.nocookie.net/disney/images/9/96/Iron-Man-AOU-Render.png/revision/latest?cb=20180410032118&path-prefix=es"
        ),
        Superhero(
            "2",
            "Spiderman",
            "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"
        ),
        Superhero(
            "3",
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