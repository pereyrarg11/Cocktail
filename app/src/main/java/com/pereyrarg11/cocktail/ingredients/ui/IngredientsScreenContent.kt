package com.pereyrarg11.cocktail.ingredients.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.common.ui.CocktailPreview
import com.pereyrarg11.cocktail.common.ui.StickyHeaderCard
import com.pereyrarg11.cocktail.common.ui.model.FilterDisplayable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IngredientsScreenContent(
    itemList: List<FilterDisplayable>,
    modifier: Modifier = Modifier,
    onItemClickListener: (FilterDisplayable) -> Unit = {},
) {
    val groups = itemList.groupBy { it.name[0].toString() }

    LazyColumn(modifier = modifier) {
        groups.forEach { (groupLabel, groupItems) ->
            stickyHeader {
                StickyHeaderCard(label = groupLabel)
            }

            items(
                items = groupItems,
                key = { displayable ->
                    displayable.query
                },
            ) { model ->
                IngredientCard(model = model) {
                    onItemClickListener(model)
                }
            }
        }
    }
}

@Preview
@Composable
fun FiltersScreenContentGroupedPreview() {
    CocktailPreview {
        IngredientsScreenContent(
            itemList = listOf(
                FilterDisplayable(name = "Gin", query = "Gin"),
                FilterDisplayable(name = "Scotch", query = "Scotch"),
                FilterDisplayable(name = "Sweet Vermouth", query = "Sweet%20Vermouth"),
                FilterDisplayable(name = "Grenadine", query = "Grenadine"),
                FilterDisplayable(name = "Irish whiskey", query = "Irish%20whiskey"),
                FilterDisplayable(name = "Red wine", query = "Red%20wine"),
                FilterDisplayable(name = "Apple cider", query = "Apple%20cider"),
                FilterDisplayable(name = "Orange", query = "Orange"),
                FilterDisplayable(name = "Absolut Citron", query = "Absolut%20Citron"),
                FilterDisplayable(name = "Pisco", query = "Pisco"),
            ),
        )
    }
}