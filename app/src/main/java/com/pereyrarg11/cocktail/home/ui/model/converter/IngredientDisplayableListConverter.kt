package com.pereyrarg11.cocktail.home.ui.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.home.data.IngredientFilterType
import com.pereyrarg11.cocktail.home.data.repository.model.IngredientContent
import com.pereyrarg11.cocktail.home.ui.model.IngredientDisplayable
import javax.inject.Inject

class IngredientDisplayableListConverter @Inject constructor(
    private val contentConverter: Converter<IngredientContent, IngredientDisplayable>,
) : Converter<@JvmSuppressWildcards List<IngredientContent>, @JvmSuppressWildcards List<IngredientDisplayable>> {

    override fun convert(input: List<IngredientContent>): List<IngredientDisplayable> {
        return input
            .filter { it.type != IngredientFilterType.UNKNOWN }
            .map { contentConverter.convert(it) }
    }
}