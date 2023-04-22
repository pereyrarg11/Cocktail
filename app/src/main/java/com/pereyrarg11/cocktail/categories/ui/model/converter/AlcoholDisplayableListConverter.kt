package com.pereyrarg11.cocktail.categories.ui.model.converter

import com.pereyrarg11.cocktail.categories.data.AlcoholFilterType
import com.pereyrarg11.cocktail.categories.data.repository.model.AlcoholContent
import com.pereyrarg11.cocktail.categories.ui.model.AlcoholDisplayable
import com.pereyrarg11.cocktail.common.data.Converter
import javax.inject.Inject

class AlcoholDisplayableListConverter @Inject constructor(
    private val contentConverter: Converter<AlcoholContent, AlcoholDisplayable>,
) : Converter<@JvmSuppressWildcards List<AlcoholContent>, @JvmSuppressWildcards List<AlcoholDisplayable>> {

    override fun convert(input: List<AlcoholContent>): List<AlcoholDisplayable> {
        return input
            .filter { content -> content.type != AlcoholFilterType.UNKNOWN }
            .map { content -> contentConverter.convert(content) }
    }
}