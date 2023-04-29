package com.pereyrarg11.cocktail.ingredients.data.repository.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.common.data.repository.model.FilterContent
import com.pereyrarg11.cocktail.ingredients.data.network.model.IngredientResponseSchema
import com.pereyrarg11.cocktail.ingredients.data.network.model.IngredientSchema
import javax.inject.Inject

class IngredientResponseConverter @Inject constructor(
    private val schemaConverter: Converter<List<IngredientSchema>, List<FilterContent>>,
) : Converter<IngredientResponseSchema, @JvmSuppressWildcards List<FilterContent>> {

    override fun convert(input: IngredientResponseSchema): List<FilterContent> {
        return if (input.drinks != null) {
            schemaConverter.convert(input.drinks)
        } else {
            emptyList()
        }
    }
}