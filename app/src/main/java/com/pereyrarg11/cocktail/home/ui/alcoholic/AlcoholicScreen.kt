package com.pereyrarg11.cocktail.home.ui.alcoholic

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.pereyrarg11.cocktail.home.ui.CategoriesUiState
import com.pereyrarg11.cocktail.home.ui.CategoriesUiState.*
import com.pereyrarg11.cocktail.home.ui.CocktailColumn
import com.pereyrarg11.cocktail.common.ui.ErrorScreen
import com.pereyrarg11.cocktail.common.ui.LoadingScreen
import com.pereyrarg11.cocktail.common.ui.navigation.Routes

@Composable
fun AlcoholicScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: AlcoholicViewModel = hiltViewModel()
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val uiState by produceState<CategoriesUiState>(
        initialValue = Loading,
        key1 = lifecycle,
        key2 = viewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            viewModel.uiState.collect { value = it }
        }
    }

    when (uiState) {
        is Error -> {
            ErrorScreen()
        }
        Loading -> {
            LoadingScreen()
        }
        is Success -> {
            Column(modifier = modifier) {
                CocktailColumn(
                    rowList = (uiState as Success).cocktailList,
                    onClickItem = { model ->
                        navHostController.navigate(Routes.CocktailDetailScreen.createRoute(model.id))
                    }
                )
            }
        }
    }
}