package com.pereyrarg11.cocktail.ingredients.data.repository.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.common.data.repository.model.FilterContent
import com.pereyrarg11.cocktail.ingredients.data.network.model.IngredientSchema
import javax.inject.Inject

class IngredientContentListConverter @Inject constructor(
    private val schemaConverter: Converter<IngredientSchema, FilterContent>,
) : Converter<@JvmSuppressWildcards List<IngredientSchema>, @JvmSuppressWildcards List<FilterContent>> {

    override fun convert(input: List<IngredientSchema>): List<FilterContent> {
        return input
            .map { schema -> schemaConverter.convert(schema) }
            .sortedBy { content -> content.name }
    }
}