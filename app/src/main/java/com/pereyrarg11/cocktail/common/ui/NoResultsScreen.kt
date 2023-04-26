package com.pereyrarg11.cocktail.common.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.cocktail.R

@Composable
fun NoResultsScreen(
    modifier: Modifier = Modifier,
    message: String = stringResource(id = R.string.message_no_results_found),
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                imageVector = Icons.Outlined.Quiz,
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(id = R.dimen.size_xxlg)),
            )
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.size_lg)))
            Text(text = message, textAlign = TextAlign.Center)
        }
    }
}

@Preview
@Composable
fun NoResultsScreenPreview() {
    CocktailPreview {
        NoResultsScreen()
    }
}