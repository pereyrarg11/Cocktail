package com.pereyrarg11.cocktail.home.ui.model

import androidx.annotation.StringRes
import com.pereyrarg11.cocktail.home.data.CategoryWrapperType

data class CategoryWrapperDisplayable(
    @StringRes
    val labelResource: Int,
    val type: CategoryWrapperType,
    val items: List<CategoryDisplayable>,
)
