package com.ruben.dam2024.features.superheroes.data.remote

import com.ruben.dam2024.features.superheroes.domain.Superhero
import retrofit2.Response
import retrofit2.http.GET

interface SuperheroService {

    //Metodos de la api: POST, GET, DELETE, PUT, PATCH, etc.

    @GET("all.json")
    suspend fun requestSuperheroes(): Response<List<Superhero>>

    @GET("id/{id}.json")
    //Tambien se puede hacer así
    //suspend fun getSuperhero(@Path("id") id: String): Superhero
    suspend fun getSuperhero(id: String): Superhero


}