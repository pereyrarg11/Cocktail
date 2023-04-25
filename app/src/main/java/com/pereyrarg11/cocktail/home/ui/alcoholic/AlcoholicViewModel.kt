package com.pereyrarg11.cocktail.home.ui.alcoholic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.cocktail.home.domain.GetAlcoholicCocktailListUseCase
import com.pereyrarg11.cocktail.home.ui.CategoriesUiState
import com.pereyrarg11.cocktail.home.ui.CategoriesUiState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class AlcoholicViewModel @Inject constructor(
    getAlcoholicCocktailListUseCase: GetAlcoholicCocktailListUseCase,
) : ViewModel() {

    val uiState: StateFlow<CategoriesUiState> = getAlcoholicCocktailListUseCase()
        .map(::Success)
        .catch { Error(it) }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            Loading
        )
}