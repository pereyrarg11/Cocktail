package com.pereyrarg11.cocktail.common.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    message: String = stringResource(id = R.string.message_loading),
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.margin_lg)))
            Text(text = message)
        }
    }
}

@Preview(showSystemUi = true, showBackground = false)
@Composable
fun LoadingScreenPreview() {
    CocktailPreview {
        LoadingScreen()
    }
}
