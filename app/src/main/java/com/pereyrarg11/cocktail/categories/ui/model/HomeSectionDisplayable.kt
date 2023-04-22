package com.pereyrarg11.cocktail.categories.ui.model

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.categories.data.HomeSectionType

data class HomeSectionDisplayable(
    @StringRes
    val labelResource: Int = 0,
    val type: HomeSectionType = HomeSectionType.UNKNOWN,
    val alcoholItems: List<AlcoholDisplayable> = emptyList(),
)
