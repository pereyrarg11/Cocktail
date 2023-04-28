package com.pereyrarg11.cocktail.ingredients.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.common.ui.CommonAppBar
import com.pereyrarg11.cocktail.common.ui.NoResultsScreen

@Composable
fun IngredientsScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CommonAppBar(title = stringResource(id = R.string.title_ingredients)) {
                navHostController.popBackStack()
            }
        }
    ) { paddingValues ->
        NoResultsScreen(modifier = Modifier.padding(paddingValues))
    }
}