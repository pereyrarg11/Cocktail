package com.pereyrarg11.cocktail.home.ui

import com.pereyrarg11.cocktail.home.ui.model.HomeSectionDisplayable

sealed interface HomeScreenUiState {

    object Loading : HomeScreenUiState

    data class Error(val throwable: Throwable) : HomeScreenUiState

    data class Success(val sections: List<HomeSectionDisplayable>) : HomeScreenUiState
}