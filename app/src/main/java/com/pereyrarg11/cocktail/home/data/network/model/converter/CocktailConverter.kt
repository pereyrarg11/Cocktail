package com.pereyrarg11.cocktail.home.data.network.model.converter

import com.pereyrarg11.cocktail.filteredDrinks.data.network.model.DrinkSchema
import com.pereyrarg11.cocktail.home.ui.model.CocktailModel
import com.pereyrarg11.cocktail.common.data.Converter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailConverter @Inject constructor() : Converter<DrinkSchema, CocktailModel> {

    override fun convert(input: DrinkSchema): CocktailModel {
        input.run {
            return CocktailModel(
                id = idDrink.orEmpty(),
                name = strDrink.orEmpty(),
                thumbnailUrl = strDrinkThumb.orEmpty(),
            )
        }
    }
}