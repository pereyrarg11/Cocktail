package com.pereyrarg11.cocktail.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.home.data.repository.model.HomeSectionContent
import com.pereyrarg11.cocktail.home.domain.GetHomeSectionsUseCase
import com.pereyrarg11.cocktail.home.ui.HomeScreenUiState.*
import com.pereyrarg11.cocktail.home.ui.model.HomeSectionDisplayable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
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