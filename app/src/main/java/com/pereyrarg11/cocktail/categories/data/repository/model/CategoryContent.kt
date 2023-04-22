package com.pereyrarg11.cocktail.categories.data.repository.model

import com.pereyrarg11.cocktail.categories.data.CategoryType

data class CategoryContent(
    val label: String = "",
    val type: CategoryType = CategoryType.OTHER,
)
