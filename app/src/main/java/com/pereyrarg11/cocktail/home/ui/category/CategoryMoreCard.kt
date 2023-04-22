package com.pereyrarg11.cocktail.home.ui.category

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R

@Composable
fun CategoryMoreCard(
    modifier: Modifier = Modifier,
    onClickListener: () -> Unit = {},
) {
    Card(
        modifier = modifier
            .width(dimensionResource(id = R.dimen.width_category_filter_card))
            .clickable {
                onClickListener()
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize(),
        ) {
            Icon(
                imageVector = Icons.Default.Add, contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.height_category_filter_card)),
            )

            CategoryText(label = stringResource(R.string.action_see_more))
        }
    }
}

@Preview
@Composable
fun CategoryMoreCardPreview() {
    CategoryMoreCard()
}