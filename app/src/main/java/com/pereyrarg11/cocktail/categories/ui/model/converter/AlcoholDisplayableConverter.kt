package com.pereyrarg11.cocktail.categories.ui.model.converter

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.data.AlcoholFilterType
import com.pereyrarg11.cocktail.categories.data.AlcoholFilterType.*
import com.pereyrarg11.cocktail.categories.data.repository.model.AlcoholContent
import com.pereyrarg11.cocktail.categories.ui.model.AlcoholDisplayable
import com.pereyrarg11.cocktail.common.data.Converter
import javax.inject.Inject

class AlcoholDisplayableConverter @Inject constructor() :
    Converter<AlcoholContent, AlcoholDisplayable> {

    override fun convert(input: AlcoholContent): AlcoholDisplayable {
        return AlcoholDisplayable(
            labelResource = getLabelResourceByType(input.type),
            imageUrl = getImageUrlByType(input.type),
            type = input.type,
        )
    }

    private fun getImageUrlByType(type: AlcoholFilterType): String {
        return when (type) {
            ALCOHOLIC -> "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg"
            NON_ALCOHOLIC -> "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg"
            OPTIONAL_ALCOHOL -> "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg"
            UNKNOWN -> ""
        }
    }

    @StringRes
    private fun getLabelResourceByType(type: AlcoholFilterType): Int {
        return when (type) {
            ALCOHOLIC -> R.string.title_category_alcoholic
            NON_ALCOHOLIC -> R.string.title_category_non_alcoholic
            OPTIONAL_ALCOHOL -> R.string.title_category_alcohol_optional
            UNKNOWN -> 0
        }
    }
}