package com.pereyrarg11.cocktail.detail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.detail.data.repository.model.content.DrinkDetailContent
import com.pereyrarg11.cocktail.detail.domain.GetDrinkDetailsUseCase
import com.pereyrarg11.cocktail.detail.ui.DrinkDetailUiState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class DrinkDetailViewModel @Inject constructor(
    val getDetailsUseCase: GetDrinkDetailsUseCase,
    val converter: Converter<DrinkDetailContent, DrinkDetailDisplayable>,
) : ViewModel() {

    fun fetchDrinkDetails(id: String): StateFlow<DrinkDetailUiState> {
        return getDetailsUseCase(id)
            .map { drinkDetailContent ->
                val drinkDetails = converter.convert(drinkDetailContent)
                Success(drinkDetails)
            }
            .catch { Error(it) }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                Loading
            )
    }
}