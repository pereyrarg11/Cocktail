package com.pereyrarg11.cocktail.home.ui.alcohol

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.common.ui.CocktailPreview
import com.pereyrarg11.cocktail.home.data.AlcoholFilterType
import com.pereyrarg11.cocktail.home.ui.model.AlcoholDisplayable

@Composable
fun AlcoholRow(
    alcoholItems: List<AlcoholDisplayable>,
    modifier: Modifier = Modifier,
    onItemClickListener: (AlcoholFilterType) -> Unit = {},
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.size_sm)),
        contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.size_md)),
    ) {
        items(alcoholItems) { model ->
            AlcoholCard(model = model) {
                onItemClickListener(model.type)
            }
        }
    }
}

@Preview
@Composable
fun AlcoholRowPreview() {
    CocktailPreview {
        AlcoholRow(
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
    }
}