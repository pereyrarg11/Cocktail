package com.pereyrarg11.cocktail.detail.data.network.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.detail.data.network.model.schema.DrinkDetailSchema
import com.pereyrarg11.cocktail.detail.data.network.model.schema.DrinkDetailWrapperSchema
import com.pereyrarg11.cocktail.detail.data.repository.model.content.DrinkDetailContent
import javax.inject.Inject

class DrinkDetailWrapperSchemaConverter @Inject constructor(
    private val drinkConverter: Converter<DrinkDetailSchema, DrinkDetailContent>,
) : Converter<DrinkDetailWrapperSchema, DrinkDetailContent> {

    override fun convert(input: DrinkDetailWrapperSchema): DrinkDetailContent {
        return if (input.drinks != null && input.drinks.isNotEmpty()) {
            drinkConverter.convert(input.drinks[0])
        } else {
            DrinkDetailContent()
        }
    }
}