package com.pereyrarg11.cocktail.home.ui.ingredient

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.home.ui.model.IngredientDisplayable

@OptIn(ExperimentalGlideComposeApi::class)
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
        val strokeWidth = dimensionResource(id = R.dimen.width_ingredient_filter_stroke)
        val imageSize = dimensionResource(id = R.dimen.size_ingredient_filter_image)

        if (isPreview) {
            Image(
                painter = painterResource(id = R.drawable.img_drink_demo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(imageSize)
                    .clip(CircleShape)
                    .border(
                        BorderStroke(strokeWidth, MaterialTheme.colorScheme.primary),
                        CircleShape
                    )
                    .padding(strokeWidth)
                    .clickable { onClickListener() },
            )

        } else {
            GlideImage(
                model = model.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(imageSize)
                    .clip(CircleShape)
                    .border(
                        BorderStroke(strokeWidth, MaterialTheme.colorScheme.primary),
                        CircleShape
                    )
                    .padding(strokeWidth)
                    .clickable { onClickListener() },
            )
        }

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