package com.pereyrarg11.cocktail.home.ui.ingredient

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.home.data.IngredientFilterType
import com.pereyrarg11.cocktail.home.data.IngredientFilterType.*
import com.pereyrarg11.cocktail.home.ui.model.IngredientDisplayable

@Composable
fun IngredientRow(
    ingredientItems: List<IngredientDisplayable>,
    modifier: Modifier = Modifier,
    onItemClickListener: (IngredientFilterType) -> Unit = {},
) {
    val cardPadding = dimensionResource(id = R.dimen.size_md)

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(cardPadding),
        contentPadding = PaddingValues(horizontal = cardPadding),
    ) {
        items(ingredientItems) { ingredient ->
            if (ingredient.type == MORE) {
                IngredientMoreCard {
                    onItemClickListener(MORE)
                }

            } else {
                IngredientCard(model = ingredient) {
                    onItemClickListener(ingredient.type)
                }
            }
        }
    }
}

@Preview
@Composable
fun IngredientRowPreview() {
    IngredientRow(
        ingredientItems = listOf(
            IngredientDisplayable(
                labelResource = R.string.title_ingredient_gin,
                imageUrl = "https://www.thecocktaildb.com/images/ingredients/gin-Small.png",
                type = GIN
            ),
            IngredientDisplayable(
                labelResource = R.string.title_ingredient_scotch,
                imageUrl = "https://www.thecocktaildb.com/images/ingredients/scotch-Small.png",
                type = SCOTCH
            ),
            IngredientDisplayable(
                labelResource = R.string.title_ingredient_brandy,
                imageUrl = "https://www.thecocktaildb.com/images/ingredients/brandy-Small.png",
                type = BRANDY
            ),
            IngredientDisplayable(
                labelResource = R.string.title_ingredient_champagne,
                imageUrl = "https://www.thecocktaildb.com/images/ingredients/champagne-Small.png",
                type = CHAMPAGNE
            ),
            IngredientDisplayable(
                labelResource = R.string.title_ingredient_tequila,
                imageUrl = "https://www.thecocktaildb.com/images/ingredients/tequila-Small.png",
                type = TEQUILA
            ),
            IngredientDisplayable(
                labelResource = R.string.title_ingredient_vodka,
                imageUrl = "https://www.thecocktaildb.com/images/ingredients/vodka-Small.png",
                type = VODKA
            ),
            IngredientDisplayable(
                labelResource = R.string.title_ingredient_kahlua,
                imageUrl = "https://www.thecocktaildb.com/images/ingredients/kahlua-Small.png",
                type = KAHLUA
            ),
            IngredientDisplayable(
                labelResource = R.string.title_ingredient_whiskey,
                imageUrl = "https://www.thecocktaildb.com/images/ingredients/whiskey-Small.png",
                type = WHISKEY
            ),
            IngredientDisplayable(
                labelResource = R.string.title_ingredient_cognac,
                imageUrl = "https://www.thecocktaildb.com/images/ingredients/cognac-Small.png",
                type = COGNAC
            ),
            IngredientDisplayable(
                labelResource = R.string.title_ingredient_pisco,
                imageUrl = "https://www.thecocktaildb.com/images/ingredients/pisco-Small.png",
                type = PISCO
            ),
            IngredientDisplayable(
                type = MORE
            ),
        )
    )
}