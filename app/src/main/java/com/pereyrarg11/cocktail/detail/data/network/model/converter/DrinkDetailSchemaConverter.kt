package com.pereyrarg11.cocktail.detail.data.network.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.detail.data.network.model.schema.DrinkDetailSchema
import com.pereyrarg11.cocktail.detail.data.repository.model.content.AlcoholDrinkCategory
import com.pereyrarg11.cocktail.detail.data.repository.model.content.DrinkDetailContent
import javax.inject.Inject

class DrinkDetailSchemaConverter @Inject constructor() :
    Converter<DrinkDetailSchema, DrinkDetailContent> {

    override fun convert(input: DrinkDetailSchema): DrinkDetailContent {
        input.run {
            return DrinkDetailContent(
                id = idDrink.orEmpty(),
                name = strDrink.orEmpty(),
                imageUrl = strDrinkThumb.orEmpty(),
                imageCopyright = strImageAttribution.orEmpty(),
                glass = strGlass.orEmpty(),
                category = strCategory.orEmpty(),
                alcoholCategory = AlcoholDrinkCategory.from(strAlcoholic.orEmpty()),
                measuredIngredients = flattenIngredients(this),
                instructions = strInstructions.orEmpty(),
            )
        }
    }

    private fun flattenIngredients(schema: DrinkDetailSchema): List<String> {
        val ingredients = listOf(
            Pair(schema.strMeasure1, schema.strIngredient1.orEmpty()),
            Pair(schema.strMeasure2, schema.strIngredient2.orEmpty()),
            Pair(schema.strMeasure3, schema.strIngredient3.orEmpty()),
            Pair(schema.strMeasure4, schema.strIngredient4.orEmpty()),
            Pair(schema.strMeasure5, schema.strIngredient5.orEmpty()),
            Pair(schema.strMeasure6, schema.strIngredient6.orEmpty()),
            Pair(schema.strMeasure7, schema.strIngredient7.orEmpty()),
            Pair(schema.strMeasure8, schema.strIngredient8.orEmpty()),
            Pair(schema.strMeasure9, schema.strIngredient9.orEmpty()),
            Pair(schema.strMeasure10, schema.strIngredient10.orEmpty()),
            Pair(schema.strMeasure11, schema.strIngredient11.orEmpty()),
            Pair(schema.strMeasure12, schema.strIngredient12.orEmpty()),
            Pair(schema.strMeasure13, schema.strIngredient13.orEmpty()),
            Pair(schema.strMeasure14, schema.strIngredient14.orEmpty()),
            Pair(schema.strMeasure15, schema.strIngredient15.orEmpty()),
        )

        return ingredients
            .filter { it.second.isNotEmpty() }
            .map { "${it.second} ${it.first}" }
    }
}