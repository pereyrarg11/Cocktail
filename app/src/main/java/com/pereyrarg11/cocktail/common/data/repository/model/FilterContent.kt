package com.pereyrarg11.cocktail.common.data.repository.model

import com.pereyrarg11.cocktail.common.data.FilterType

data class FilterContent(
    val name: String = "",
    val query: String = "",
    val imageUrl: String = "",
    val type: FilterType = FilterType.UNKNOWN,
)
