package com.pereyrarg11.cocktail.home.ui.ingredient

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R

@Composable
fun IngredientMoreCard(
    modifier: Modifier = Modifier,
    onClickListener: () -> Unit = {},
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val strokeWidth = dimensionResource(id = R.dimen.width_ingredient_filter_stroke)
        val imageSize = dimensionResource(id = R.dimen.size_ingredient_filter_image)

        Icon(
            imageVector = Icons.Default.Add, contentDescription = null,
            modifier = Modifier
                .size(imageSize)
                .border(
                    BorderStroke(strokeWidth, MaterialTheme.colorScheme.primary),
                    CircleShape
                )
                .padding(strokeWidth)
                .clickable { onClickListener() },
        )

        IngredientText(
            label = stringResource(id = R.string.action_see_more),
            modifier = Modifier
                .widthIn(max = imageSize.times(1.5f))
        )
    }
}

@Preview
@Composable
fun IngredientMoreCardPreview() {
    IngredientMoreCard()
}