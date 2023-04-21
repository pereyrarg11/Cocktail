package com.pereyrarg11.cocktail.categories.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.categories.ui.alcohol.AlcoholCategoryRowPreview
import com.pereyrarg11.cocktail.common.ui.CocktailPreview

@Composable
fun CategoryRow(
    label: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier) {
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
        content()
    }
}

@Preview
@Composable
fun CategoryRowPreview() {
    CocktailPreview {
        CategoryRow(label = stringResource(R.string.title_category_wrapper_alcohol)) {
            AlcoholCategoryRowPreview()
        }
    }
}