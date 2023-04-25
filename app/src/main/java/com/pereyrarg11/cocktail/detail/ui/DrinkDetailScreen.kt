package com.pereyrarg11.cocktail.detail.ui

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
import com.pereyrarg11.cocktail.detail.ui.DrinkDetailUiState.*

@Composable
fun DrinkDetailScreen(
    cocktailId: String,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: DrinkDetailViewModel = hiltViewModel(),
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val uiState by produceState<DrinkDetailUiState>(
        initialValue = Loading,
        key1 = lifecycle,
        key2 = viewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            viewModel.fetchDrinkDetails(cocktailId).collect { value = it }
        }
    }

    Scaffold(
        topBar = {
            CommonAppBar(
                title = stringResource(R.string.title_drink),
            ) {
                navController.popBackStack()
            }
        },
        modifier = modifier,
    ) { innerPadding ->
        when (uiState) {
            is Error -> {
                ErrorScreen(modifier = Modifier.padding(innerPadding))
            }
            Loading -> {
                LoadingScreen(modifier = Modifier.padding(innerPadding))
            }
            is Success -> {
                val drinkDetail = (uiState as Success).drink
                DrinkDetailScreenContent(
                    drinkDetail = drinkDetail,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}