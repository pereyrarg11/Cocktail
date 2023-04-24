package com.pereyrarg11.cocktail.home.ui.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.home.data.CategoryFilterType
import com.pereyrarg11.cocktail.home.data.repository.model.CategoryContent
import com.pereyrarg11.cocktail.home.ui.model.CategoryDisplayable
import javax.inject.Inject

class CategoryDisplayableListConverter @Inject constructor(
    private val contentConverter: Converter<CategoryContent, CategoryDisplayable>,
) : Converter<@JvmSuppressWildcards List<CategoryContent>, @JvmSuppressWildcards List<CategoryDisplayable>> {

    override fun convert(input: List<CategoryContent>): List<CategoryDisplayable> {
        return input
            .filter { content -> content.type != CategoryFilterType.UNKNOWN }
            .map { content -> contentConverter.convert(content) }
    }
}