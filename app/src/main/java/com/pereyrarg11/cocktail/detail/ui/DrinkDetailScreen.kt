package com.pereyrarg11.cocktail.detail.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
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
        topBar = { DrinkDetailAppBar(navController) },
        modifier = modifier,
    ) {
        when (uiState) {
            is Error -> {
                ErrorScreen()
            }
            Loading -> {
                LoadingScreen()
            }
            is Success -> {
                val drinkDetail = (uiState as Success).drink
                DrinkDetailScreenContent(drinkDetail = drinkDetail)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkDetailAppBar(navController: NavHostController) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.title_drink))
        },
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() },
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.action_back)
                )
            }
        },
    )
}