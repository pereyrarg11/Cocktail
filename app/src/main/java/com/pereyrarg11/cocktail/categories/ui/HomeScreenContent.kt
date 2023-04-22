package com.pereyrarg11.cocktail.categories.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.data.AlcoholFilterType
import com.pereyrarg11.cocktail.categories.data.HomeSectionType
import com.pereyrarg11.cocktail.categories.ui.alcohol.AlcoholRow
import com.pereyrarg11.cocktail.categories.ui.model.AlcoholDisplayable
import com.pereyrarg11.cocktail.categories.ui.model.HomeSectionDisplayable
import com.pereyrarg11.cocktail.common.ui.CocktailPreview

@Composable
fun HomeScreenContent(
    sections: List<HomeSectionDisplayable>,
    modifier: Modifier = Modifier,
    onAlcoholClickListener: (AlcoholFilterType) -> Unit = {},
) {
    Column(modifier = modifier) {
        sections.forEach { section ->
            val label = if (section.labelResource != 0) {
                stringResource(id = section.labelResource)
            } else {
                ""
            }

            HomeScreenSlot(label = label) {
                /* set the @Composable content */
                when (section.type) {
                    HomeSectionType.ALCOHOL -> {
                        AlcoholRow(
                            categories = section.alcoholItems,
                            onItemClickListener = onAlcoholClickListener,
                        )
                    }
                    HomeSectionType.UNKNOWN -> {}
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
                    type = HomeSectionType.ALCOHOL,
                    alcoholItems = listOf(
                        AlcoholDisplayable(
                            labelResource = R.string.title_category_alcoholic,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
                        ),
                        AlcoholDisplayable(
                            labelResource = R.string.title_category_non_alcoholic,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg",
                        ),
                        AlcoholDisplayable(
                            labelResource = R.string.title_category_alcohol_optional,
                            imageUrl = "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg",
                        )
                    )
                )
            )
        )
    }
}