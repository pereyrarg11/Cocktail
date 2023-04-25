package com.pereyrarg11.cocktail.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.common.ui.CocktailPreview
import com.pereyrarg11.cocktail.home.data.AlcoholFilterType
import com.pereyrarg11.cocktail.home.data.CategoryFilterType
import com.pereyrarg11.cocktail.home.data.HomeSectionType.*
import com.pereyrarg11.cocktail.home.data.IngredientFilterType
import com.pereyrarg11.cocktail.home.ui.alcohol.AlcoholRow
import com.pereyrarg11.cocktail.home.ui.category.CategoryGrid
import com.pereyrarg11.cocktail.home.ui.ingredient.IngredientRow
import com.pereyrarg11.cocktail.home.ui.model.AlcoholDisplayable
import com.pereyrarg11.cocktail.home.ui.model.HomeSectionDisplayable

@Composable
fun HomeScreenContent(
    sections: List<HomeSectionDisplayable>,
    modifier: Modifier = Modifier,
    onAlcoholClickListener: (AlcoholFilterType) -> Unit = {},
    onCategoryClickListener: (CategoryFilterType) -> Unit = {},
    onIngredientClickListener: (IngredientFilterType) -> Unit = {},
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
    ) {
        sections.forEach { section ->
            val label = if (section.labelResource != 0) {
                stringResource(id = section.labelResource)
            } else {
                ""
            }

            HomeScreenSlot(label = label) {
                /* set the @Composable content */
                when (section.type) {
                    ALCOHOL -> {
                        AlcoholRow(
                            alcoholItems = section.alcoholItems,
                            onItemClickListener = onAlcoholClickListener,
                        )
                    }
                    CATEGORIES -> {
                        CategoryGrid(
                            categoryItems = section.categoryItems,
                            onCategoryClickListener = onCategoryClickListener
                        )
                    }
                    INGREDIENTS -> {
                        IngredientRow(
                            ingredientItems = section.ingredientItems,
                            onItemClickListener = onIngredientClickListener
                        )
                    }
                    UNKNOWN -> {}
                }
            }
        }

        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.size_md)))
    }
}

@Preview
@Composable
fun CategoriesScreenContentPreview() {
    CocktailPreview {
        HomeScreenContent(
            sections = listOf(
                HomeSectionDisplayable(
                    type = ALCOHOL,
                    alcoholItems = listOf(
                        AlcoholDisplayable(
                            labelResource = R.string.title_alcohol_filter_alcoholic,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
                        ),
                        AlcoholDisplayable(
                            labelResource = R.string.title_alcohol_filter_non_alcoholic,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg",
                        ),
                        AlcoholDisplayable(
                            labelResource = R.string.title_alcohol_filter_alcohol_optional,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg",
                        )
                    )
                )
            )
        )
    }
}
