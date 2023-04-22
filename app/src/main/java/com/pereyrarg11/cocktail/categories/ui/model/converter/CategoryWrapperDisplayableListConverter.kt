package com.pereyrarg11.cocktail.categories.ui.model.converter

import com.pereyrarg11.cocktail.categories.data.CategoryWrapperType
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryWrapperContent
import com.pereyrarg11.cocktail.categories.ui.model.CategoryWrapperDisplayable
import com.pereyrarg11.cocktail.common.data.Converter
import javax.inject.Inject

class CategoryWrapperDisplayableListConverter @Inject constructor(
    private val wrapperConverter: Converter<CategoryWrapperContent, CategoryWrapperDisplayable>,
) : Converter<@JvmSuppressWildcards List<CategoryWrapperContent>, @JvmSuppressWildcards List<CategoryWrapperDisplayable>> {

    override fun convert(input: List<CategoryWrapperContent>): List<CategoryWrapperDisplayable> {
        return input
            .map { content ->
                wrapperConverter.convert(content)
            }.filter { displayable ->
                displayable.type != CategoryWrapperType.EMPTY && displayable.items.isNotEmpty()
            }
    }
}