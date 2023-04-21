package com.pereyrarg11.cocktail.categories.ui.model

import com.pereyrarg11.cocktail.categories.ui.CategoryFilter

data class CategoryItemDisplayable(
    val label: String,
    val imageUrl: String = "",
    val categoryFilter: CategoryFilter = CategoryFilter.OTHER,
)
