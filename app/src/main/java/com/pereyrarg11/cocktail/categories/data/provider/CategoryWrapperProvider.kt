package com.pereyrarg11.cocktail.categories.data.provider

import com.pereyrarg11.cocktail.categories.data.CategoryWrapperType
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryWrapperContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryWrapperProvider @Inject constructor(
    categoryProvider: CategoryProvider,
) {

    val categoryWrappers: List<CategoryWrapperContent> = listOf(
        CategoryWrapperContent(
            type = CategoryWrapperType.ALCOHOL,
            items = categoryProvider.alcoholCategories
        ),
    )
}