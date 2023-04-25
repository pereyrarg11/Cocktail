package com.pereyrarg11.cocktail.filteredDrinks.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.pereyrarg11.cocktail.common.data.FilterType
import com.pereyrarg11.cocktail.common.ui.CommonAppBar
import com.pereyrarg11.cocktail.common.ui.navigation.Routes

@Composable
fun FilteredDrinksScreen(
    query: String,
    title: String,
    filterType: FilterType,
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CommonAppBar(title = title) {
                navHostController.popBackStack()
            }
        }
    ) {
        FilteredDrinkScreenContent(
            drinkList = emptyList(),
            modifier = modifier
        ) { drinkId ->
            navHostController.navigate(Routes.CocktailDetailScreen.createRoute(drinkId))
        }
    }
}