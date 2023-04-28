package com.pereyrarg11.cocktail.home.ui.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.home.data.CategoryFilterType
import com.pereyrarg11.cocktail.home.ui.model.CategoryDisplayable

@Composable
fun CategoryGrid(
    categoryItems: List<CategoryDisplayable>,
    modifier: Modifier = Modifier,
    onCategoryClickListener: (CategoryFilterType, String) -> Unit = { _, _ -> },
) {
    val maxRows = integerResource(id = R.integer.category_grid_max_rows)
    val padding = dimensionResource(id = R.dimen.size_md)
    val cardHeight = dimensionResource(id = R.dimen.height_category_filter_card)

    LazyHorizontalGrid(
        rows = GridCells.Fixed(maxRows),
        horizontalArrangement = Arrangement.spacedBy(padding),
        verticalArrangement = Arrangement.spacedBy(padding),
        contentPadding = PaddingValues(horizontal = padding),
        modifier = modifier.height(
            cardHeight.times(maxRows) + padding.times(maxRows - 1)
        ),
    ) {
        items(categoryItems) { category ->
            val label = if (category.labelResource != 0) {
                stringResource(id = category.labelResource)
            } else {
                ""
            }

            if (category.type == CategoryFilterType.MORE) {
                CategoryMoreCard(
                    modifier = Modifier.height(cardHeight)
                ) {
                    onCategoryClickListener(category.type, label)
                }

            } else {
                CategoryCard(
                    model = category,
                    modifier = Modifier.height(cardHeight)
                ) {
                    onCategoryClickListener(category.type, label)
                }
            }
        }
    }
}

@Preview
@Composable
fun CategoryGridPreview() {
    CategoryGrid(
        categoryItems = listOf(
            CategoryDisplayable(
                labelResource = R.string.title_category_cocktail,
                imageUrl = "https://www.thecocktaildb.com/images/media/drink/rptuxy1472669372.jpg",
                type = CategoryFilterType.COCKTAIL,
            ),
            CategoryDisplayable(
                labelResource = R.string.title_category_shake,
                imageUrl = "https://www.thecocktaildb.com/images/media/drink/uvypss1472720581.jpg",
                type = CategoryFilterType.SHAKE,
            ),
            CategoryDisplayable(
                labelResource = R.string.title_category_shot,
                imageUrl = "https://www.thecocktaildb.com/images/media/drink/rtpxqw1468877562.jpg",
                type = CategoryFilterType.SHOT,
            ),
            CategoryDisplayable(
                labelResource = R.string.title_category_beer,
                imageUrl = "https://www.thecocktaildb.com/images/media/drink/rwpswp1454511017.jpg",
                type = CategoryFilterType.BEER,
            ),
            CategoryDisplayable(
                labelResource = R.string.title_category_coffee_and_tea,
                imageUrl = "https://www.thecocktaildb.com/images/media/drink/vqwptt1441247711.jpg",
                type = CategoryFilterType.COFFEE_AND_TEA,
            ),
            CategoryDisplayable(
                type = CategoryFilterType.MORE,
            )
        )
    )
}