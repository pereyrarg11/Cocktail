package com.pereyrarg11.cocktail.home.ui.model

import com.pereyrarg11.cocktail.home.data.AlcoholFilterType

data class AlcoholDisplayable(
    val labelResource: Int = 0,
    val imageUrl: String = "",
    val type: AlcoholFilterType = AlcoholFilterType.UNKNOWN,
)
