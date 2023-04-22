package com.pereyrarg11.cocktail.categories.ui.model.converter

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.data.CategoryFilter
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryContent
import com.pereyrarg11.cocktail.categories.ui.model.CategoryItemDisplayable
import com.pereyrarg11.cocktail.common.data.Converter
import javax.inject.Inject

class CategoryDisplayableConverter @Inject constructor() :
    Converter<CategoryContent, CategoryItemDisplayable> {

    override fun convert(input: CategoryContent): CategoryItemDisplayable {
        input.run {
            return CategoryItemDisplayable(
                labelResource = getLabelResourceByCategoryType(type),
                imageUrl = getImageUrlByCategoryType(type),
                categoryFilter = type
            )
        }
    }

    @StringRes
    private fun getLabelResourceByCategoryType(categoryType: CategoryFilter): Int {
        return when (categoryType) {
            CategoryFilter.ALCOHOLIC -> R.string.title_category_alcoholic
            CategoryFilter.NON_ALCOHOLIC -> R.string.title_category_non_alcoholic
            CategoryFilter.ALCOHOL_OPTIONAL -> R.string.title_category_alcohol_optional
            CategoryFilter.OTHER -> R.string.title_category_alcohol_other
        }
    }

    private fun getImageUrlByCategoryType(categoryType: CategoryFilter): String {
        return when (categoryType) {
            CategoryFilter.ALCOHOLIC -> "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg"
            CategoryFilter.NON_ALCOHOLIC -> "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg"
            CategoryFilter.ALCOHOL_OPTIONAL -> "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg"
            CategoryFilter.OTHER -> "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg"
        }
    }
}