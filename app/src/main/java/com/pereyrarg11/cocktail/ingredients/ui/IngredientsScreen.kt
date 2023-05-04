package com.pereyrarg11.cocktail.ingredients.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.pereyrarg11.cocktail.R
import com.pereyrarg11.cocktail.common.ui.CommonAppBar
import com.pereyrarg11.cocktail.common.ui.ErrorScreen
import com.pereyrarg11.cocktail.common.ui.LoadingScreen
import com.pereyrarg11.cocktail.common.ui.NoResultsScreen
import com.pereyrarg11.cocktail.common.ui.navigation.Routes
import com.pereyrarg11.cocktail.ingredients.ui.IngredientsUiState.*

@Composable
fun IngredientsScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: IngredientsViewModel = hiltViewModel(),
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val uiState by produceState<IngredientsUiState>(
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
        topBar = {
            CommonAppBar(title = stringResource(id = R.string.title_ingredients)) {
                navHostController.popBackStack()
            }
        }
    ) { paddingValues ->
        when (uiState) {
            is Error -> ErrorScreen(modifier = Modifier.padding(paddingValues))
            Loading -> LoadingScreen(modifier = Modifier.padding(paddingValues))
            is Success -> {
                val ingredients = (uiState as Success).items

                if (ingredients.isEmpty()) {
                    NoResultsScreen(modifier = Modifier.padding(paddingValues))
                } else {
                    IngredientsScreenContent(
                        itemList = ingredients,
                        modifier = Modifier.padding(paddingValues),
                    ) { ingredient ->
                        navHostController.navigate(
                            Routes.IngredientDrinksScreen.createRoute(
                                query = ingredient.query,
                                title = ingredient.name
                            )
                        )
                    }
                }
            }
        }
    }
}