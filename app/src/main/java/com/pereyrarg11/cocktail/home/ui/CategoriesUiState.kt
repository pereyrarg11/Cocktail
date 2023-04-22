package com.pereyrarg11.cocktail.home.ui

import com.pereyrarg11.cocktail.home.ui.model.CocktailModel

sealed interface CategoriesUiState {
    object Loading : CategoriesUiState

    data class Error(val throwable: Throwable) : CategoriesUiState

    data class Success(val cocktailList: List<CocktailModel>) : CategoriesUiState
}