package com.pereyrarg11.cocktail.common.ui.model.converter

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.common.data.repository.model.FilterContent
import com.pereyrarg11.cocktail.common.ui.model.FilterDisplayable
import javax.inject.Inject

class FilterDisplayableConverter @Inject constructor() :
    Converter<FilterContent, FilterDisplayable> {

    override fun convert(input: FilterContent): FilterDisplayable {
        return FilterDisplayable(
            name = input.name,
            query = input.query,
            imageUrl = input.imageUrl,
            type = input.type,
        )
    }
}