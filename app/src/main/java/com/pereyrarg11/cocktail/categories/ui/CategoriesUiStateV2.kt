package com.pereyrarg11.cocktail.categories.ui

import com.pereyrarg11.cocktail.categories.ui.model.CategoryWrapperDisplayable

sealed interface CategoriesUiStateV2 {
    object Loading : CategoriesUiStateV2

    data class Error(val throwable: Throwable) : CategoriesUiStateV2

    data class Success(val wrappers: List<CategoryWrapperDisplayable>) : CategoriesUiStateV2
}