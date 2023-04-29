package com.pereyrarg11.cocktail.ingredients.ui

import com.pereyrarg11.cocktail.common.ui.model.FilterDisplayable

sealed interface IngredientsUiState {

    object Loading : IngredientsUiState

    data class Error(val throwable: Throwable) : IngredientsUiState

    data class Success(val items: List<FilterDisplayable>) : IngredientsUiState
}