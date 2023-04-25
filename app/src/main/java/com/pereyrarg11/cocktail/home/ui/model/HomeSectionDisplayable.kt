package com.pereyrarg11.cocktail.home.ui.model

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.home.data.HomeSectionType

data class HomeSectionDisplayable(
    @StringRes
    val labelResource: Int = 0,
    val type: HomeSectionType = HomeSectionType.UNKNOWN,
    val alcoholItems: List<AlcoholDisplayable> = emptyList(),
    val categoryItems: List<CategoryDisplayable> = emptyList(),
    val ingredientItems: List<IngredientDisplayable> = emptyList(),
)
