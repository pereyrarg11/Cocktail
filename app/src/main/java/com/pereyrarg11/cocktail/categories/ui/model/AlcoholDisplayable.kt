package com.pereyrarg11.cocktail.categories.ui.model

import com.pereyrarg11.cocktail.categories.data.AlcoholFilterType

data class AlcoholDisplayable(
    val labelResource: Int = 0,
    val imageUrl: String = "",
    val type: AlcoholFilterType = AlcoholFilterType.UNKNOWN,
)
