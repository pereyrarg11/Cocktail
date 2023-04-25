package com.pereyrarg11.cocktail.home.ui.ingredient

import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.pereyrarg11.cocktail.R

@Composable
fun IngredientText(
    label: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = label,
        style = MaterialTheme.typography.headlineSmall,
        modifier = modifier
            .paddingFromBaseline(
                top = dimensionResource(id = R.dimen.size_lg),
                bottom = dimensionResource(id = R.dimen.size_sm)
            ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center,
    )
}