package com.pereyrarg11.cocktail.categories.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.ui.model.CocktailModel
import com.pereyrarg11.cocktail.ui.theme.CocktailTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CocktailRow(
    model: CocktailModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = R.dimen.margin_md),
                vertical = dimensionResource(id = R.dimen.margin_sm)
            )
            .clickable { onClick() },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            GlideImage(
                model = "${model.thumbnailUrl}/preview",
                contentDescription = null,
                modifier = Modifier.size(100.dp),
            )
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.margin_md)))
            Text(text = model.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CocktailRowPreview() {
    CocktailTheme {
        CocktailRow(
            model = CocktailModel(
                name = "Margarita",
                thumbnailUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
                id = "11007"
            )
        )
    }
}