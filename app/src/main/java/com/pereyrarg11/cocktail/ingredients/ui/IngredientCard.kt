package com.pereyrarg11.cocktail.ingredients.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.common.ui.IngredientImage
import com.pereyrarg11.cocktail.common.ui.model.FilterDisplayable

@Composable
fun IngredientCard(
    model: FilterDisplayable,
    modifier: Modifier = Modifier,
    isPreview: Boolean = LocalInspectionMode.current,
    onClickListener: () -> Unit = {},
) {
    ListItem(
        modifier = modifier.clickable { onClickListener() },
        leadingContent = {
            IngredientImage(
                modifier = modifier.size(dimensionResource(id = R.dimen.size_ingredient_filter_image_sm)),
                imageUrl = model.imageUrl,
                isPreview = isPreview,
            )
        },
        headlineContent = {
            Text(text = model.name)
        },
    )
}

@Preview
@Composable
fun IngredientCardPreview() {
    IngredientCard(
        model = FilterDisplayable(
            name = "Midori melon liqueur",
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/Midori%20melon%20liqueur-Small.png"
        )
    )
}