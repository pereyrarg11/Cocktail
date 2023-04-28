package com.pereyrarg11.cocktail.filteredDrinks.ui

import com.pereyrarg11.cocktail.filteredDrinks.ui.model.DrinkDisplayable

sealed interface FilteredDrinksUiState {

    object Loading : FilteredDrinksUiState

    data class Error(val throwable: Throwable) : FilteredDrinksUiState

    data class Success(val drinks: List<DrinkDisplayable>) : FilteredDrinksUiState
}