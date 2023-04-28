package com.pereyrarg11.cocktail.common.ui.model

import com.pereyrarg11.cocktail.common.data.FilterType

data class FilterDisplayable(
    val name: String = "",
    val query: String = "",
    val imageUrl: String = "",
    val type: FilterType = FilterType.UNKNOWN,
)