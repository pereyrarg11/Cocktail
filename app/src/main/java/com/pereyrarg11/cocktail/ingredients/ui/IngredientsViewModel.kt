package com.pereyrarg11.cocktail.ingredients.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.common.data.repository.model.FilterContent
import com.pereyrarg11.cocktail.common.ui.model.FilterDisplayable
import com.pereyrarg11.cocktail.ingredients.domain.GetIngredientsUseCase
import com.pereyrarg11.cocktail.ingredients.ui.IngredientsUiState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class IngredientsViewModel @Inject constructor(
    getIngredientsUseCase: GetIngredientsUseCase,
    ingredientsConverter: Converter<List<FilterContent>, List<FilterDisplayable>>,
) : ViewModel() {

    val uiState: StateFlow<IngredientsUiState> = getIngredientsUseCase()
        .map { filterContents ->
            val displayableItems = ingredientsConverter.convert(filterContents)
            Success(displayableItems)
        }
        .catch { throwable -> Error(throwable) }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            Loading
        )
}