package com.ruben.dam2024.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruben.dam2024.app.domain.ErrorApp
import com.ruben.dam2024.features.movies.presentation.MovieDetailViewModel
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroUseCase
import com.ruben.dam2024.features.superheroes.domain.Superhero
import kotlinx.coroutines.launch

class SuperheroDetailViewModel(
    private val getSuperheroUseCase: GetSuperheroUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun viewCreated(superheroId: String){
        viewModelScope.launch {
            val superhero = getSuperheroUseCase.invoke(superheroId)
            _uiState.postValue(UiState(superhero = superhero))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superhero: Superhero? = null
    )
}