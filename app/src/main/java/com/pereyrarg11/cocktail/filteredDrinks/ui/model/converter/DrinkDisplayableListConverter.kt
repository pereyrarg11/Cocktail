package com.pereyrarg11.cocktail.filteredDrinks.ui.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.DrinkContent
import com.pereyrarg11.cocktail.filteredDrinks.ui.model.DrinkDisplayable
import javax.inject.Inject

class DrinkDisplayableListConverter @Inject constructor(
    private val contentConverter: Converter<DrinkContent, DrinkDisplayable>,
) : Converter<@JvmSuppressWildcards List<DrinkContent>, @JvmSuppressWildcards List<DrinkDisplayable>> {

    override fun convert(input: List<DrinkContent>): List<DrinkDisplayable> {
        return input.map { drinkContent -> contentConverter.convert(drinkContent) }
    }
}