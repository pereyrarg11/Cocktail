package com.pereyrarg11.cocktail.categories.ui.model.converter

import com.pereyrarg11.cocktail.categories.data.HomeSectionType
import com.pereyrarg11.cocktail.categories.data.repository.model.HomeSectionContent
import com.pereyrarg11.cocktail.categories.ui.model.HomeSectionDisplayable
import com.pereyrarg11.cocktail.common.data.Converter
import javax.inject.Inject

class HomeSectionDisplayableListConverter @Inject constructor(
    private val contentConverter: Converter<HomeSectionContent, HomeSectionDisplayable>,
) : Converter<@JvmSuppressWildcards List<HomeSectionContent>, @JvmSuppressWildcards List<HomeSectionDisplayable>> {

    override fun convert(input: List<HomeSectionContent>): List<HomeSectionDisplayable> {
        return input
            .map { content -> contentConverter.convert(content) }
            .filter { displayable -> displayable.type != HomeSectionType.UNKNOWN }
    }
}