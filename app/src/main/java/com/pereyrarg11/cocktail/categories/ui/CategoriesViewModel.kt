package com.pereyrarg11.cocktail.categories.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.cocktail.categories.data.repository.model.HomeSectionContent
import com.pereyrarg11.cocktail.categories.domain.GetHomeSectionsUseCase
import com.pereyrarg11.cocktail.categories.ui.HomeScreenUiState.*
import com.pereyrarg11.cocktail.categories.ui.model.HomeSectionDisplayable
import com.pereyrarg11.cocktail.common.data.Converter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    getHomeSectionsUseCase: GetHomeSectionsUseCase,
    sectionsConverter: Converter<List<HomeSectionContent>, List<HomeSectionDisplayable>>,
) : ViewModel() {

    val uiState: StateFlow<HomeScreenUiState> =
        getHomeSectionsUseCase()
            .map { contents ->
                val sections = sectionsConverter.convert(contents)
                Success(sections)
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