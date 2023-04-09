package com.pereyrarg11.cocktail.categories.data.network.model.converter

import com.pereyrarg11.cocktail.categories.data.network.model.schema.CocktailSchema
import com.pereyrarg11.cocktail.categories.ui.model.CocktailModel
import com.pereyrarg11.cocktail.data.Converter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailConverter @Inject constructor() : Converter<CocktailSchema, CocktailModel> {

    override fun convert(input: CocktailSchema): CocktailModel {
        input.run {
            return CocktailModel(
                id = idDrink.orEmpty(),
                name = strDrink.orEmpty(),
                thumbnailUrl = strDrinkThumb.orEmpty(),
            )
        }
    }
}