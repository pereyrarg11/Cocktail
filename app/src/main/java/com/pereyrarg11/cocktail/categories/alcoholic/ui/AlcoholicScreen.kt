package com.pereyrarg11.cocktail.categories.alcoholic.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pereyrarg11.cocktail.categories.ui.CategoriesUiState
import com.pereyrarg11.cocktail.categories.ui.CategoriesUiState.*
import com.pereyrarg11.cocktail.categories.ui.CocktailColumn

@Composable
fun AlcoholicScreen(
    modifier: Modifier = Modifier,
    viewModel: AlcoholicViewModel = viewModel(),
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
            // TODO: define a composable for this case
        }
        Loading -> {
            // TODO: define a composable for this case
        }
        is Success -> {
            Column(modifier = modifier) {
                CocktailColumn(
                    rowList = (uiState as Success).cocktailList,
                    onClickItem = { model ->
                        Log.i("AlcoholicScreen", "you have clicked on ${model.name}")
                    }
                )
            }
        }
    }
}