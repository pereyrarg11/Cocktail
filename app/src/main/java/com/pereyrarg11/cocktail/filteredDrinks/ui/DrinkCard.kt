package com.pereyrarg11.cocktail.filteredDrinks.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.filteredDrinks.ui.model.DrinkDisplayable

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DrinkCard(
    model: DrinkDisplayable,
    modifier: Modifier = Modifier,
    isPreview: Boolean = LocalInspectionMode.current,
    onClickListener: () -> Unit = {},
) {
    val padding = dimensionResource(id = R.dimen.size_md)

    Card(
        modifier = modifier
            .clickable { onClickListener() }
            .padding(horizontal = padding)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (isPreview) {
                Image(
                    painter = painterResource(id = R.drawable.img_drink_demo),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.size_filtered_drink_image))
                )
            } else {
                GlideImage(
                    model = model.imageUrl,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.size_filtered_drink_image))
                )
            }
            Spacer(modifier = Modifier.size(padding))
            Text(text = model.name)
        }
    }
}

@Preview
@Composable
fun DrinkCardPreview() {
    DrinkCard(
        model = DrinkDisplayable(
            id = "11007",
            name = "Margarita",
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg/preview"
        )
    )
}