package com.pereyrarg11.cocktail.categories.ui.model

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.categories.data.CategoryWrapperType

data class CategoryWrapperDisplayable(
    @StringRes
    val labelResource: Int,
    val type: CategoryWrapperType,
    val items: List<CategoryItemDisplayable>,
)
