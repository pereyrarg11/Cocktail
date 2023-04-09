package com.pereyrarg11.cocktail.categories.alcoholic.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pereyrarg11.cocktail.categories.ui.CocktailColumn

@Composable
fun AlcoholicScreen(
    modifier: Modifier = Modifier,
    viewModel: AlcoholicViewModel = viewModel(),
) {
    Column(modifier = modifier) {
        CocktailColumn(
            rowList = viewModel.cocktailList,
            onClickItem = { model ->
                Log.i("AlcoholicScreen", "you have clicked on ${model.name}")
            }
        )
    }
}