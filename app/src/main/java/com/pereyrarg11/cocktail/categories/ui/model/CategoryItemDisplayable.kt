package com.pereyrarg11.cocktail.categories.ui.model

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.categories.data.CategoryType

// TODO: can be renamed to CategoryDisplayable
data class CategoryItemDisplayable(
    @StringRes
    val labelResource: Int,
    val imageUrl: String = "",
    val categoryType: CategoryType = CategoryType.OTHER,
)
