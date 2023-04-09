package com.pereyrarg11.cocktail.categories.data.network.model.converter

import com.pereyrarg11.cocktail.categories.data.network.model.schema.CocktailListSchema
import com.pereyrarg11.cocktail.categories.data.network.model.schema.CocktailSchema
import com.pereyrarg11.cocktail.categories.ui.model.CocktailModel
import com.pereyrarg11.cocktail.data.Converter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailListConverter @Inject constructor(
    private val cocktailConverter: Converter<CocktailSchema, CocktailModel>,
) : Converter<CocktailListSchema, List<@JvmSuppressWildcards CocktailModel>> {

    override fun convert(input: CocktailListSchema): List<CocktailModel> {
        if (input.drinks != null) {
            return input.drinks
                .map { cocktailSchema -> cocktailConverter.convert(cocktailSchema) }
                .filter { cocktailModel -> cocktailModel.id.isNotEmpty() }
        }

        return emptyList()
    }
}