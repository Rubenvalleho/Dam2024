package com.ruben.dam2024.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruben.dam2024.app.domain.ErrorApp
import com.ruben.dam2024.features.superheroes.domain.GetSuperheroesUseCase
import com.ruben.dam2024.features.superheroes.domain.Superhero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperheroListViewModel(private val getSuperheroesUseCase: GetSuperheroesUseCase): ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadSuperheroes() {
        viewModelScope.launch(Dispatchers.IO) {
            val superheroes = getSuperheroesUseCase.invoke()
            _uiState.postValue(UiState(superheroes = superheroes))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val superheroes: List<Superhero>? = null,
        val errorApp: ErrorApp? = null
    )

}