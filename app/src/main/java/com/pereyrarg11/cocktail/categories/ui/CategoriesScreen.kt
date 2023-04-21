package com.pereyrarg11.cocktail.categories.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.ui.model.CategoryItemDisplayable
import com.pereyrarg11.cocktail.categories.ui.model.CategoryWrapperDisplayable

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
    ) { innerPadding ->
        CategoriesScreenContent(
            categoryWrapperList = listOf(
                CategoryWrapperDisplayable(
                    labelResource = R.string.title_category_wrapper_alcohol,
                    type = CategoryWrapperType.ALCOHOL,
                    items = listOf(
                        CategoryItemDisplayable(
                            labelResource = R.string.title_category_alcoholic,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
                        ),
                        CategoryItemDisplayable(
                            labelResource = R.string.title_category_non_alcoholic,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg",
                        ),
                        CategoryItemDisplayable(
                            labelResource = R.string.title_category_alcohol_optional,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg",
                        )
                    )
                )
            ),
            modifier = Modifier.padding(innerPadding)
        )
    }
}
