package com.pereyrarg11.cocktail.detail.ui

// TODO: is it possible to extend functions from another sealed interface?
sealed interface DrinkDetailUiState {

    object Loading : DrinkDetailUiState

    data class Error(val throwable: Throwable) : DrinkDetailUiState

    data class Success(val drink: DrinkDetailDisplayable) : DrinkDetailUiState
}