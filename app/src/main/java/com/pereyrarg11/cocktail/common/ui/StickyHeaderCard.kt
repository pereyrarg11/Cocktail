package com.pereyrarg11.cocktail.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R

@Composable
fun StickyHeaderCard(
    label: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = label,
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = R.dimen.size_md),
                vertical = dimensionResource(id = R.dimen.size_sm)
            ),
        color = MaterialTheme.colorScheme.onPrimary,
    )
}

@Preview
@Composable
fun StickyHeaderCardPreview() {
    StickyHeaderCard(label = "Cocktail")
}