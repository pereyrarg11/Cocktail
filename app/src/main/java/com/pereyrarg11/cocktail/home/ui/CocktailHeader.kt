package com.pereyrarg11.cocktail.home.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R

@Composable
fun CocktailHeader(label: String) {
    Surface(
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(
            text = label,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(id = R.dimen.size_md),
                    vertical = dimensionResource(id = R.dimen.size_xs)
                )
        )
    }
}

@Preview
@Composable
fun CocktailHeaderPreview() {
    CocktailHeader(label = "A")
}
