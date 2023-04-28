package com.pereyrarg11.cocktail.filteredDrinks.ui.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.DrinkContent
import com.pereyrarg11.cocktail.filteredDrinks.ui.model.DrinkDisplayable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkDisplayableConverter @Inject constructor() : Converter<DrinkContent, DrinkDisplayable> {

    override fun convert(input: DrinkContent): DrinkDisplayable {
        return DrinkDisplayable(
            id = input.id,
            name = input.name,
            imageUrl = transformImageUrl(input.imageUrl),
        )
    }

    private fun transformImageUrl(imageUrl: String): String {
        return if (imageUrl.isNotEmpty()) {
            "$imageUrl/preview"
        } else {
            ""
        }
    }
}