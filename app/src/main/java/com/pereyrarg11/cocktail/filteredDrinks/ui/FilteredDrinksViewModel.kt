package com.pereyrarg11.cocktail.filteredDrinks.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.common.data.FilterType
import com.pereyrarg11.cocktail.common.data.FilterType.*
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.DrinkContent
import com.pereyrarg11.cocktail.filteredDrinks.domain.GetDrinksByAlcoholUseCase
import com.pereyrarg11.cocktail.filteredDrinks.domain.GetDrinksByCategoryUseCase
import com.pereyrarg11.cocktail.filteredDrinks.domain.GetDrinksByIngredientUseCase
import com.pereyrarg11.cocktail.filteredDrinks.ui.FilteredDrinksUiState.*
import com.pereyrarg11.cocktail.filteredDrinks.ui.model.DrinkDisplayable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class FilteredDrinksViewModel @Inject constructor(
    val getDrinksByAlcoholUseCase: GetDrinksByAlcoholUseCase,
    val getDrinksByCategoryUseCase: GetDrinksByCategoryUseCase,
    val getDrinksByIngredientUseCase: GetDrinksByIngredientUseCase,
    private val drinksConverter: Converter<List<DrinkContent>, List<DrinkDisplayable>>,
) : ViewModel() {

    fun filterDrinks(filterType: FilterType, query: String): StateFlow<FilteredDrinksUiState> {
        val flow: Flow<List<DrinkContent>> = when (filterType) {
            ALCOHOL -> getDrinksByAlcoholUseCase(query)
            CATEGORY -> getDrinksByCategoryUseCase(query)
            INGREDIENT -> getDrinksByIngredientUseCase(query)
            UNKNOWN -> flow { emit(emptyList()) }
        }

        return flow
            .map { contentItems ->
                val displayableItems = drinksConverter.convert(contentItems)
                Success(displayableItems)
            }
            .catch { throwable -> Error(throwable) }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                Loading
            )
    }
}