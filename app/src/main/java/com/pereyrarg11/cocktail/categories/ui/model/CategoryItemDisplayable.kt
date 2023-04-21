package com.pereyrarg11.cocktail.categories.ui.model

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.categories.ui.CategoryFilter

data class CategoryItemDisplayable(
    @StringRes
    val labelResource: Int,
    val imageUrl: String = "",
    val categoryFilter: CategoryFilter = CategoryFilter.OTHER,
)
