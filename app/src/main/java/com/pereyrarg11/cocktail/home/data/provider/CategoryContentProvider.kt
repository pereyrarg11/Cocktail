package com.pereyrarg11.cocktail.home.data.provider

import com.pereyrarg11.cocktail.home.data.CategoryFilterType
import com.pereyrarg11.cocktail.home.data.repository.model.CategoryContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryContentProvider @Inject constructor() {

    val categoryItems = CategoryFilterType.values()
        .filter { it != CategoryFilterType.UNKNOWN }
        .map { CategoryContent(it) }
}