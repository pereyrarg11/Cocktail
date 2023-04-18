package com.pereyrarg11.cocktail.detail.data.repository.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.detail.data.repository.model.content.DrinkDetailContent
import com.pereyrarg11.cocktail.detail.ui.DrinkDetailDisplayable
import javax.inject.Inject

class DrinkDetailContentConverter @Inject constructor() :
    Converter<DrinkDetailContent, DrinkDetailDisplayable> {

    override fun convert(input: DrinkDetailContent): DrinkDetailDisplayable {
        input.run {
            return DrinkDetailDisplayable(
                name = name,
                alcohol = alcoholCategory.description,
                category = category,
                glass = glass,
                imageUrl = imageUrl,
                imageCopyright = imageCopyright,
                ingredients = measuredIngredients,
                instructions = instructions,
            )
        }
    }
}