package com.pereyrarg11.cocktail.filteredDrinks.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.pereyrarg11.cocktail.common.data.FilterType
import com.pereyrarg11.cocktail.common.ui.CommonAppBar
import com.pereyrarg11.cocktail.common.ui.ErrorScreen
import com.pereyrarg11.cocktail.common.ui.LoadingScreen
import com.pereyrarg11.cocktail.common.ui.NoResultsScreen
import com.pereyrarg11.cocktail.common.ui.navigation.Routes
import com.pereyrarg11.cocktail.filteredDrinks.ui.FilteredDrinksUiState.*

@Composable
fun FilteredDrinksScreen(
    query: String,
    title: String,
    filterType: FilterType,
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: FilteredDrinksViewModel = hiltViewModel(),
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val uiState by produceState<FilteredDrinksUiState>(
        initialValue = Loading,
        key1 = lifecycle,
        key2 = viewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            viewModel.filterDrinks(filterType, query).collect { value = it }
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            CommonAppBar(title = title) {
                navHostController.popBackStack()
            }
        }
    ) { innerPadding ->
        when (uiState) {
            is Error -> ErrorScreen(modifier = Modifier.padding(innerPadding))
            Loading -> LoadingScreen(modifier = Modifier.padding(innerPadding))
            is Success -> {
                val drinks = (uiState as Success).drinks

                if (drinks.isEmpty()) {
                    NoResultsScreen(modifier = Modifier.padding(innerPadding))
                } else {
                    FilteredDrinkScreenContent(
                        drinkList = drinks,
                        modifier = Modifier.padding(innerPadding)
                    ) { drinkId ->
                        navHostController.navigate(Routes.CocktailDetailScreen.createRoute(drinkId))
                    }
                }
            }
        }
    }
}