package com.pereyrarg11.cocktail.home.ui.model.converter

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.home.data.HomeSectionType
import com.pereyrarg11.cocktail.home.data.HomeSectionType.*
import com.pereyrarg11.cocktail.home.data.repository.model.AlcoholContent
import com.pereyrarg11.cocktail.home.data.repository.model.CategoryContent
import com.pereyrarg11.cocktail.home.data.repository.model.HomeSectionContent
import com.pereyrarg11.cocktail.home.ui.model.AlcoholDisplayable
import com.pereyrarg11.cocktail.home.ui.model.CategoryDisplayable
import com.pereyrarg11.cocktail.home.ui.model.HomeSectionDisplayable
import javax.inject.Inject

class HomeSectionDisplayableConverter @Inject constructor(
    private val alcoholConverter: Converter<List<AlcoholContent>, List<AlcoholDisplayable>>,
    private val categoryConverter: Converter<List<CategoryContent>, List<CategoryDisplayable>>,
) : Converter<HomeSectionContent, HomeSectionDisplayable> {

    override fun convert(input: HomeSectionContent): HomeSectionDisplayable {
        return HomeSectionDisplayable(
            labelResource = getLabelResourceByType(input.type),
            type = input.type,
            alcoholItems = alcoholConverter.convert(input.alcoholItems),
            categoryItems = categoryConverter.convert(input.categoryItems),
        )
    }

    @StringRes
    private fun getLabelResourceByType(type: HomeSectionType): Int {
        return when(type) {
            ALCOHOL -> 0
            CATEGORIES -> R.string.title_categories
            UNKNOWN -> 0
        }
    }
}