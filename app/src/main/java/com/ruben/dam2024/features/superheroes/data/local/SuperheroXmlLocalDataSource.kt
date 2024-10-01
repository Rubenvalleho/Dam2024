package com.ruben.dam2024.features.superheroes.data.local

import android.content.Context
import android.provider.Settings.Global.getString
import com.google.gson.Gson
import com.ruben.dam2024.R
import com.ruben.dam2024.features.superheroes.domain.Superhero

class SuperheroXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_superhero_xml), Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(superhero: Superhero) {
        val editor = sharedPref.edit()
        editor.putString(superhero.id, gson.toJson(superhero))
        editor.apply()
    }

    fun saveAll(superheroes: List<Superhero>) {
        val editor = sharedPref.edit()
        superheroes.forEach { superhero ->
            editor.putString(superhero.id, gson.toJson(superhero))
        }
        editor.apply()
    }

    fun findById(id: String): Superhero? {
        return sharedPref.getString(id, null)?.let { superhero ->
            gson.fromJson(superhero, Superhero::class.java)
        }
    }

    fun findAll(): List<Superhero> {
        val superheroes = mutableListOf<Superhero>()
        val mapSuperheroes = sharedPref.all
        mapSuperheroes.values.forEach { jsonSuperhero ->
            val superhero = gson.fromJson(jsonSuperhero as String, Superhero::class.java)
            superheroes.add(superhero)
        }
        return superheroes
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }

    fun deleteById(id: String) {
        sharedPref.edit().remove(id).commit()
    }
}