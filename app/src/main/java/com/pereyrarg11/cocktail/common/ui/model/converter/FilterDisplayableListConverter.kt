package com.pereyrarg11.cocktail.common.ui.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.common.data.FilterType
import com.pereyrarg11.cocktail.common.data.repository.model.FilterContent
import com.pereyrarg11.cocktail.common.ui.model.FilterDisplayable
import javax.inject.Inject

class FilterDisplayableListConverter @Inject constructor(
    private val converter: Converter<FilterContent, FilterDisplayable>,
) : Converter<@JvmSuppressWildcards List<FilterContent>, @JvmSuppressWildcards List<FilterDisplayable>> {

    override fun convert(input: List<FilterContent>): List<FilterDisplayable> {
        return input
            .filter { content -> content.type != FilterType.UNKNOWN }
            .map { content -> converter.convert(content) }
    }
}