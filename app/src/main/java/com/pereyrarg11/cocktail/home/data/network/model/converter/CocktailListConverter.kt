package com.pereyrarg11.cocktail.home.data.network.model.converter

import com.pereyrarg11.cocktail.filteredDrinks.data.network.model.DrinkListSchema
import com.pereyrarg11.cocktail.filteredDrinks.data.network.model.DrinkSchema
import com.pereyrarg11.cocktail.home.ui.model.CocktailModel
import com.pereyrarg11.cocktail.common.data.Converter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailListConverter @Inject constructor(
    private val cocktailConverter: Converter<DrinkSchema, CocktailModel>,
) : Converter<DrinkListSchema, List<@JvmSuppressWildcards CocktailModel>> {

    override fun convert(input: DrinkListSchema): List<CocktailModel> {
        if (input.drinks != null) {
            return input.drinks
                .map { cocktailSchema -> cocktailConverter.convert(cocktailSchema) }
                .filter { cocktailModel -> cocktailModel.id.isNotEmpty() }
        }

        return emptyList()
    }
}