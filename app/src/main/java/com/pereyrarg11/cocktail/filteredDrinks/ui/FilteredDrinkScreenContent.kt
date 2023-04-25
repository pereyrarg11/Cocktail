package com.pereyrarg11.cocktail.filteredDrinks.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.common.ui.StickyHeaderCard
import com.pereyrarg11.cocktail.filteredDrinks.ui.model.DrinkDisplayable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FilteredDrinkScreenContent(
    drinkList: List<DrinkDisplayable>,
    modifier: Modifier = Modifier,
    onDrinkClickListener: (String) -> Unit = {},
) {
    val padding = dimensionResource(id = R.dimen.size_md)
    val groups = drinkList.groupBy { it.name[0] }

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(bottom = padding),
        verticalArrangement = Arrangement.spacedBy(padding),
    ) {
        groups.forEach { (groupLabel, groupItems) ->
            stickyHeader {
                StickyHeaderCard(label = groupLabel.toString())
            }

            items(
                items = groupItems,
                key = { displayable ->
                    displayable.id
                }
            ) { displayable ->
                DrinkCard(model = displayable) {
                    onDrinkClickListener(displayable.id)
                }
            }
        }
    }
}

@Preview
@Composable
fun FilteredDrinkScreenContentPreview() {
    FilteredDrinkScreenContent(
        drinkList = listOf(
            DrinkDisplayable(
                name = "Applejack",
                imageUrl = "https://www.thecocktaildb.com/images/media/drink/sutyqp1479209062.jpg/preview",
                id = "16311"
            ),
            DrinkDisplayable(
                name = "Margarita",
                imageUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg/preview",
                id = "11007"
            ),
            DrinkDisplayable(
                name = "Mojito",
                imageUrl = "https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg/preview",
                id = "11000"
            ),
        )
    )
}