package com.pereyrarg11.cocktail.categories.ui.model.converter

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.data.CategoryType
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryContent
import com.pereyrarg11.cocktail.categories.ui.model.CategoryDisplayable
import com.pereyrarg11.cocktail.common.data.Converter
import javax.inject.Inject

class CategoryDisplayableConverter @Inject constructor() :
    Converter<CategoryContent, CategoryDisplayable> {

    override fun convert(input: CategoryContent): CategoryDisplayable {
        input.run {
            return CategoryDisplayable(
                labelResource = getLabelResourceByCategoryType(type),
                imageUrl = getImageUrlByCategoryType(type),
                categoryType = type
            )
        }
    }

    @StringRes
    private fun getLabelResourceByCategoryType(categoryType: CategoryType): Int {
        return when (categoryType) {
            CategoryType.ALCOHOLIC -> R.string.title_category_alcoholic
            CategoryType.NON_ALCOHOLIC -> R.string.title_category_non_alcoholic
            CategoryType.ALCOHOL_OPTIONAL -> R.string.title_category_alcohol_optional
            CategoryType.OTHER -> R.string.title_category_alcohol_other
        }
    }

    private fun getImageUrlByCategoryType(categoryType: CategoryType): String {
        return when (categoryType) {
            CategoryType.ALCOHOLIC -> "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg"
            CategoryType.NON_ALCOHOLIC -> "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg"
            CategoryType.ALCOHOL_OPTIONAL -> "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg"
            CategoryType.OTHER -> "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg"
        }
    }
}