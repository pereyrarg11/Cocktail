package com.pereyrarg11.cocktail.home.ui.model

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.home.data.CategoryFilterType

data class CategoryDisplayable(
    @StringRes
    val labelResource: Int = 0,
    val imageUrl: String = "",
    val type: CategoryFilterType = CategoryFilterType.UNKNOWN,
)
