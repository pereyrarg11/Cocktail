package com.pereyrarg11.cocktail.categories.ui

import com.pereyrarg11.cocktail.categories.ui.model.CocktailModel

sealed interface CategoriesUiState {
    object Loading : CategoriesUiState

    data class Error(val throwable: Throwable) : CategoriesUiState

    data class Success(val cocktailList: List<CocktailModel>) : CategoriesUiState
}