package com.pereyrarg11.cocktail.categories.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryWrapperContent
import com.pereyrarg11.cocktail.categories.domain.GetCategoriesUseCase
import com.pereyrarg11.cocktail.categories.ui.CategoriesUiStateV2.*
import com.pereyrarg11.cocktail.categories.ui.model.CategoryWrapperDisplayable
import com.pereyrarg11.cocktail.common.data.Converter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    getCategoriesUseCase: GetCategoriesUseCase,
    wrapperListConverter: Converter<List<CategoryWrapperContent>, List<CategoryWrapperDisplayable>>,
) : ViewModel() {

    val uiState: StateFlow<CategoriesUiStateV2> =
        getCategoriesUseCase()
            .map { wrapperContentList ->
                val wrappers = wrapperListConverter.convert(wrapperContentList)
                Success(wrappers)
            }
            .catch { throwable ->
                Error(throwable)
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                Loading
            )
}