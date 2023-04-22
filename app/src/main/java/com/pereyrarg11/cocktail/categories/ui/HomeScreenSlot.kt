package com.pereyrarg11.cocktail.categories.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.ui.alcohol.AlcoholRowPreview
import com.pereyrarg11.cocktail.common.ui.CocktailPreview

@Composable
fun HomeScreenSlot(
    label: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier) {
        if (label.isNotEmpty()) {
            Text(
                text = label,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.size_md))
                    .paddingFromBaseline(
                        top = dimensionResource(id = R.dimen.size_xxlg),
                        bottom = dimensionResource(id = R.dimen.size_md)
                    )
            )
        } else {
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.size_md)))
        }
        content()
    }
}

@Preview
@Composable
fun CategoryRowPreview() {
    CocktailPreview {
        HomeScreenSlot(label = "") {
            AlcoholRowPreview()
        }
    }
}