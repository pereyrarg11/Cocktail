package com.pereyrarg11.cocktail.categories.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.ui.model.CocktailModel
import com.pereyrarg11.cocktail.ui.theme.CocktailTheme

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
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.margin_md)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
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