package com.pereyrarg11.cocktail.categories.ui.model

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.categories.data.CategoryType

data class CategoryDisplayable(
    @StringRes
    val labelResource: Int,
    val imageUrl: String = "",
    val categoryType: CategoryType = CategoryType.OTHER,
)
