package com.pereyrarg11.cocktail.categories.ui.model.converter

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.data.CategoryWrapperType
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryContent
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryWrapperContent
import com.pereyrarg11.cocktail.categories.ui.model.CategoryItemDisplayable
import com.pereyrarg11.cocktail.categories.ui.model.CategoryWrapperDisplayable
import com.pereyrarg11.cocktail.common.data.Converter
import javax.inject.Inject

class CategoryWrapperDisplayableConverter @Inject constructor(
    private val categoryListConverter: Converter<List<CategoryContent>, List<CategoryItemDisplayable>>
) : Converter<CategoryWrapperContent, CategoryWrapperDisplayable> {

    override fun convert(input: CategoryWrapperContent): CategoryWrapperDisplayable {
        input.run {
            return CategoryWrapperDisplayable(
                labelResource = getLabelResourceByCategoryWrapperType(input.type),
                type = input.type,
                items = categoryListConverter.convert(input.items)
            )
        }
    }

    @StringRes
    private fun getLabelResourceByCategoryWrapperType(type: CategoryWrapperType): Int {
        return when (type) {
            CategoryWrapperType.ALCOHOL -> R.string.title_category_wrapper_alcohol
            else -> 0
        }
    }
}