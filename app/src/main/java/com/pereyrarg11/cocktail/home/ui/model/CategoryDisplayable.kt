package com.pereyrarg11.cocktail.home.ui.model

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.home.data.CategoryType

data class CategoryDisplayable(
    @StringRes
    val labelResource: Int,
    val imageUrl: String = "",
    val categoryType: CategoryType = CategoryType.OTHER,
)
