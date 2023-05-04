package com.pereyrarg11.cocktail.ingredients.data.repository.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.common.data.FilterType
import com.pereyrarg11.cocktail.common.data.repository.model.FilterContent
import com.pereyrarg11.cocktail.ingredients.data.network.model.IngredientSchema
import javax.inject.Inject

class IngredientContentConverter @Inject constructor() :
    Converter<IngredientSchema, FilterContent> {

    override fun convert(input: IngredientSchema): FilterContent {
        // TODO: inject as a dependency
        val encodedName = input.strIngredient1.orEmpty().replace(" ", "%20")

        return FilterContent(
            name = input.strIngredient1.orEmpty(),
            query = encodedName,
            // TODO: inject as dependency
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/$encodedName-Small.png",
            type = FilterType.INGREDIENT,
        )
    }
}