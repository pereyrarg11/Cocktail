package com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.filteredDrinks.data.network.model.DrinkListSchema
import com.pereyrarg11.cocktail.filteredDrinks.data.network.model.DrinkSchema
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.DrinkContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkContentListConverter @Inject constructor(
    private val schemaConverter: Converter<DrinkSchema, DrinkContent>,
) : Converter<DrinkListSchema, @JvmSuppressWildcards List<DrinkContent>> {

    override fun convert(input: DrinkListSchema): List<DrinkContent> {
        return if (input.drinks != null) {
            input.drinks
                .map { schema -> schemaConverter.convert(schema) }
                .filter { content -> content.id.isNotEmpty() && content.name.isNotEmpty() }

        } else {
            emptyList()
        }
    }
}