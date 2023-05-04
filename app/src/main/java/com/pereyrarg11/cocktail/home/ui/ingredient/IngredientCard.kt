package com.pereyrarg11.cocktail.home.ui.ingredient

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.common.ui.IngredientImage
import com.pereyrarg11.cocktail.home.ui.model.IngredientDisplayable

@Composable
fun IngredientCard(
    model: IngredientDisplayable,
    modifier: Modifier = Modifier,
    isPreview: Boolean = LocalInspectionMode.current,
    onClickListener: () -> Unit = {},
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val imageSize = dimensionResource(id = R.dimen.size_ingredient_filter_image)

        IngredientImage(
            modifier = Modifier.size(imageSize),
            imageUrl = model.imageUrl,
            isPreview = isPreview,
            onClickListener = onClickListener,
        )

        IngredientText(
            label = stringResource(id = model.labelResource),
            modifier = Modifier
                .widthIn(max = imageSize.times(1.5f))
        )
    }
}

@Preview
@Composable
fun IngredientCardPreview() {
    IngredientCard(
        model = IngredientDisplayable(
            labelResource = R.string.title_ingredient_tequila,
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/tequila-Small.png",
        )
    )
}