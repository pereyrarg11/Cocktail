package com.pereyrarg11.cocktail.home.ui

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
import com.pereyrarg11.cocktail.common.ui.ErrorScreen
import com.pereyrarg11.cocktail.common.ui.LoadingScreen
import com.pereyrarg11.cocktail.common.ui.navigation.Routes
import com.pereyrarg11.cocktail.home.data.AlcoholFilterType
import com.pereyrarg11.cocktail.home.data.AlcoholFilterType.*
import com.pereyrarg11.cocktail.home.data.CategoryFilterType
import com.pereyrarg11.cocktail.home.data.CategoryFilterType.*
import com.pereyrarg11.cocktail.home.data.IngredientFilterType
import com.pereyrarg11.cocktail.home.data.IngredientFilterType.*
import com.pereyrarg11.cocktail.home.ui.HomeScreenUiState.*

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val uiState by produceState<HomeScreenUiState>(
        initialValue = Loading,
        key1 = lifecycle,
        key2 = viewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            viewModel.uiState.collect { value = it }
        }
    }

    Scaffold(
        modifier = modifier,
    ) { innerPadding ->
        when (uiState) {
            is Error -> ErrorScreen(modifier = Modifier.padding(innerPadding))
            Loading -> LoadingScreen(modifier = Modifier.padding(innerPadding))
            is Success -> {
                HomeScreenContent(
                    sections = (uiState as Success).sections,
                    modifier = Modifier.padding(innerPadding),
                    onAlcoholClickListener = { type, title ->
                        navigateToAlcoholDrinks(navHostController, type, title)
                    },
                    onCategoryClickListener = { type, title ->
                        navigateToCategoryDrinks(navHostController, type, title)
                    },
                    onIngredientClickListener = { type, title ->
                        navigateToIngredientDrinks(navHostController, type, title)
                    },
                )
            }
        }
    }
}

private fun navigateToAlcoholDrinks(
    navHostController: NavHostController,
    type: AlcoholFilterType,
    title: String,
) {
    val route = when (type) {
        ALCOHOLIC,
        NON_ALCOHOLIC,
        OPTIONAL_ALCOHOL -> {
            Routes.AlcoholDrinksScreen.createRoute(type.query, title)
        }
        AlcoholFilterType.UNKNOWN -> null
    }

    if (route != null) {
        navHostController.navigate(route)
    }
}

private fun navigateToCategoryDrinks(
    navHostController: NavHostController,
    type: CategoryFilterType,
    title: String,
) {
    val route = when (type) {
        COCKTAIL,
        SHAKE,
        SHOT,
        BEER,
        COFFEE_AND_TEA -> {
            Routes.CategoryDrinksScreen.createRoute(type.query, title)
        }
        CategoryFilterType.MORE -> null
        CategoryFilterType.UNKNOWN -> null
    }

    if (route != null) {
        navHostController.navigate(route)
    }
}

private fun navigateToIngredientDrinks(
    navHostController: NavHostController,
    type: IngredientFilterType,
    title: String,
) {
    val route = when (type) {
        GIN,
        SCOTCH,
        BRANDY,
        CHAMPAGNE,
        TEQUILA,
        VODKA,
        KAHLUA,
        WHISKEY,
        COGNAC,
        PISCO -> {
            Routes.IngredientDrinksScreen.createRoute(type.query, title)
        }
        IngredientFilterType.MORE -> null
        IngredientFilterType.UNKNOWN -> null
    }

    if (route != null) {
        navHostController.navigate(route)
    }
}