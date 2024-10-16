package com.ruben.dam2024.app.data.api

import com.ruben.dam2024.features.superheroes.data.remote.SuperheroService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    //La url que no cambia termina con /
    private const val BASE_URL_API = "https://akabab.github.io/superhero-api/api/"

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideSuperheroService(): SuperheroService {
        return provideRetrofit().create(SuperheroService::class.java)
    }

}