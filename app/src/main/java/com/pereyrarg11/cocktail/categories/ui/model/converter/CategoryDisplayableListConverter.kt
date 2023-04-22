package com.pereyrarg11.cocktail.categories.ui.model.converter

import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryContent
import com.pereyrarg11.cocktail.categories.ui.model.CategoryDisplayable
import com.pereyrarg11.cocktail.common.data.Converter
import javax.inject.Inject

class CategoryDisplayableListConverter @Inject constructor(
    private val categoryConverter: Converter<CategoryContent, CategoryDisplayable>,
) : Converter<@JvmSuppressWildcards List<CategoryContent>, @JvmSuppressWildcards List<CategoryDisplayable>> {

    override fun convert(input: List<CategoryContent>): List<CategoryDisplayable> {
        return input.map { content ->
            categoryConverter.convert(content)
        }
    }
}