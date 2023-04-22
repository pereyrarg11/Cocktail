package com.pereyrarg11.cocktail.categories.data.repository.model

import com.pereyrarg11.cocktail.categories.data.CategoryWrapperType

data class CategoryWrapperContent(
    val type: CategoryWrapperType = CategoryWrapperType.EMPTY,
    val items: List<CategoryContent> = emptyList(),
)
