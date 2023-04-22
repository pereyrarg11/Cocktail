package com.pereyrarg11.cocktail.categories.data.repository.model

import com.pereyrarg11.cocktail.categories.data.CategoryFilter

data class CategoryContent(
    val label: String = "",
    val type: CategoryFilter = CategoryFilter.OTHER,
)
