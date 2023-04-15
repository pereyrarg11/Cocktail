package com.pereyrarg11.cocktail.categories.ui

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
import com.pereyrarg11.cocktail.categories.ui.model.CocktailModel
import com.pereyrarg11.cocktail.ui.theme.CocktailTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CocktailColumn(
    modifier: Modifier = Modifier,
    rowList: List<CocktailModel> = emptyList(),
    onClickItem: (CocktailModel) -> Unit = {},
) {
    val grouped = rowList.groupBy { it.name[0] }

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            bottom = dimensionResource(id = R.dimen.margin_md)
        ),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.margin_md))
    ) {
        grouped.forEach { (initial, itemsForInitial) ->
            stickyHeader {
                CocktailHeader(label = initial.toString())
            }

            items(
                items = itemsForInitial,
                key = { itemModel ->
                    itemModel.id
                }
            ) { cocktailModel ->
                CocktailRow(
                    model = cocktailModel,
                    onClick = {
                        onClickItem(cocktailModel)
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CocktailColumnPreview() {
    CocktailTheme {
        CocktailColumn(
            rowList = listOf(
                CocktailModel(
                    name = "Applejack",
                    thumbnailUrl = "https://www.thecocktaildb.com/images/media/drink/sutyqp1479209062.jpg",
                    id = "16311"
                ),
                CocktailModel(
                    name = "Margarita",
                    thumbnailUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
                    id = "11007"
                ),
                CocktailModel(
                    name = "Mojito",
                    thumbnailUrl = "https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg",
                    id = "11000"
                ),
            )
        )
    }
}