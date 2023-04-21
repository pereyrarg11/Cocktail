package com.pereyrarg11.cocktail.categories.ui.alcohol

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.ui.CategoryFilter
import com.pereyrarg11.cocktail.categories.ui.model.CategoryItemDisplayable
import com.pereyrarg11.cocktail.common.ui.CocktailPreview

@Composable
fun AlcoholCategoryRow(
    categories: List<CategoryItemDisplayable>,
    modifier: Modifier = Modifier,
    onItemClickListener: (CategoryFilter) -> Unit = {},
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.size_sm)),
        contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.size_md)),
    ) {
        items(categories) { category ->
            AlcoholCategoryCard(category = category, onClickListener = onItemClickListener)
        }
    }
}

@Preview
@Composable
fun AlcoholCategoryRowPreview() {
    CocktailPreview {
        AlcoholCategoryRow(
            categories = listOf(
                CategoryItemDisplayable(
                    label = stringResource(R.string.title_category_alcoholic),
                    imageUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
                ),
                CategoryItemDisplayable(
                    label = stringResource(R.string.title_category_non_alcoholic),
                    imageUrl = "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg",
                ),
                CategoryItemDisplayable(
                    label = stringResource(R.string.title_category_alcohol_optional),
                    imageUrl = "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg",
                )
            )
        )
    }
}