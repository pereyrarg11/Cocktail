package com.pereyrarg11.cocktail.categories.data.provider

import com.pereyrarg11.cocktail.categories.data.CategoryFilter
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryProvider @Inject constructor() {

    companion object {
        private fun getAlcoholCategories(): List<CategoryContent> {
            return listOf(
                CategoryContent(type = CategoryFilter.ALCOHOLIC),
                CategoryContent(type = CategoryFilter.NON_ALCOHOLIC),
                CategoryContent(type = CategoryFilter.ALCOHOL_OPTIONAL),
            )
        }
    }

    val alcoholCategories: List<CategoryContent> = getAlcoholCategories()
}