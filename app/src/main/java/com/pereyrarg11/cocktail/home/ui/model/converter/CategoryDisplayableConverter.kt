package com.pereyrarg11.cocktail.home.ui.model.converter

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.home.data.CategoryFilterType
import com.pereyrarg11.cocktail.home.data.CategoryFilterType.*
import com.pereyrarg11.cocktail.home.data.repository.model.CategoryContent
import com.pereyrarg11.cocktail.home.ui.model.CategoryDisplayable
import javax.inject.Inject

class CategoryDisplayableConverter @Inject constructor() :
    Converter<CategoryContent, CategoryDisplayable> {

    override fun convert(input: CategoryContent): CategoryDisplayable {
        return CategoryDisplayable(
            labelResource = getLabelResourceByType(input.type),
            imageUrl = getImageUrlByType(input.type),
            type = input.type,
        )
    }

    @StringRes
    private fun getLabelResourceByType(type: CategoryFilterType): Int {
        return when (type) {
            COCKTAIL -> R.string.title_category_cocktail
            SHAKE -> R.string.title_category_shake
            SHOT -> R.string.title_category_shot
            BEER -> R.string.title_category_beer
            COFFEE_AND_TEA -> R.string.title_category_coffee_and_tea
            MORE,
            UNKNOWN -> 0
        }
    }

    private fun getImageUrlByType(type: CategoryFilterType): String {
        return when (type) {
            COCKTAIL -> "https://www.thecocktaildb.com/images/media/drink/rptuxy1472669372.jpg"
            SHAKE -> "https://www.thecocktaildb.com/images/media/drink/uvypss1472720581.jpg"
            SHOT -> "https://www.thecocktaildb.com/images/media/drink/rtpxqw1468877562.jpg"
            BEER -> "https://www.thecocktaildb.com/images/media/drink/rwpswp1454511017.jpg"
            COFFEE_AND_TEA -> "https://www.thecocktaildb.com/images/media/drink/vqwptt1441247711.jpg"
            MORE,
            UNKNOWN -> ""
        }
    }
}