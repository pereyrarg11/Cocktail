package com.pereyrarg11.cocktail.home.ui.model.converter

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.home.data.IngredientFilterType
import com.pereyrarg11.cocktail.home.data.IngredientFilterType.*
import com.pereyrarg11.cocktail.home.data.repository.model.IngredientContent
import com.pereyrarg11.cocktail.home.ui.model.IngredientDisplayable
import javax.inject.Inject

class IngredientDisplayableConverter @Inject constructor() :
    Converter<IngredientContent, IngredientDisplayable> {

    override fun convert(input: IngredientContent): IngredientDisplayable {
        return IngredientDisplayable(
            labelResource = getLabelResourceByType(input.type),
            imageUrl = getImageUrlByType(input.type),
            type = input.type,
        )
    }

    @StringRes
    private fun getLabelResourceByType(type: IngredientFilterType): Int {
        return when (type) {
            GIN -> R.string.title_ingredient_gin
            SCOTCH -> R.string.title_ingredient_scotch
            BRANDY -> R.string.title_ingredient_brandy
            CHAMPAGNE -> R.string.title_ingredient_champagne
            TEQUILA -> R.string.title_ingredient_tequila
            VODKA -> R.string.title_ingredient_vodka
            KAHLUA -> R.string.title_ingredient_kahlua
            WHISKEY -> R.string.title_ingredient_whiskey
            COGNAC -> R.string.title_ingredient_cognac
            PISCO -> R.string.title_ingredient_pisco
            MORE,
            UNKNOWN -> 0
        }
    }

    private fun getImageUrlByType(type: IngredientFilterType): String {
        return when (type) {
            GIN -> "https://www.thecocktaildb.com/images/ingredients/gin-Small.png"
            SCOTCH -> "https://www.thecocktaildb.com/images/ingredients/scotch-Small.png"
            BRANDY -> "https://www.thecocktaildb.com/images/ingredients/brandy-Small.png"
            CHAMPAGNE -> "https://www.thecocktaildb.com/images/ingredients/champagne-Small.png"
            TEQUILA -> "https://www.thecocktaildb.com/images/ingredients/tequila-Small.png"
            VODKA -> "https://www.thecocktaildb.com/images/ingredients/vodka-Small.png"
            KAHLUA -> "https://www.thecocktaildb.com/images/ingredients/kahlua-Small.png"
            WHISKEY -> "https://www.thecocktaildb.com/images/ingredients/whiskey-Small.png"
            COGNAC -> "https://www.thecocktaildb.com/images/ingredients/cognac-Small.png"
            PISCO -> "https://www.thecocktaildb.com/images/ingredients/pisco-Small.png"
            MORE,
            UNKNOWN -> ""
        }
    }
}