package com.pereyrarg11.cocktail.categories.data.provider

import com.pereyrarg11.cocktail.categories.data.CategoryType
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryProvider @Inject constructor() {

    companion object {
        private fun getAlcoholCategories(): List<CategoryContent> {
            return listOf(
                CategoryContent(type = CategoryType.ALCOHOLIC),
                CategoryContent(type = CategoryType.NON_ALCOHOLIC),
                CategoryContent(type = CategoryType.ALCOHOL_OPTIONAL),
            )
        }
    }

    val alcoholCategories: List<CategoryContent> = getAlcoholCategories()
}