package com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.filteredDrinks.data.network.model.DrinkSchema
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.DrinkContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkContentConverter @Inject constructor() : Converter<DrinkSchema, DrinkContent> {

    override fun convert(input: DrinkSchema): DrinkContent {
        return DrinkContent(
            id = input.idDrink.orEmpty(),
            name = input.strDrink.orEmpty(),
            imageUrl = input.strDrinkThumb.orEmpty(),
        )
    }
}