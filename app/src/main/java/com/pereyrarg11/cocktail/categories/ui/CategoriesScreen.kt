package com.pereyrarg11.cocktail.categories.ui

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
import com.pereyrarg11.cocktail.categories.ui.CategoriesUiStateV2.*
import com.pereyrarg11.cocktail.common.ui.ErrorScreen
import com.pereyrarg11.cocktail.common.ui.LoadingScreen

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    viewModel: CategoriesViewModel = hiltViewModel(),
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val uiState by produceState<CategoriesUiStateV2>(
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
                    sections = emptyList(),
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
