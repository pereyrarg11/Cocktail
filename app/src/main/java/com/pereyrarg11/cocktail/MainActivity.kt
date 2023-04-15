package com.pereyrarg11.cocktail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pereyrarg11.cocktail.categories.ui.alcoholic.AlcoholicScreen
import com.pereyrarg11.cocktail.ui.theme.CocktailTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailTheme {
                CocktailAppContent(Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun CocktailAppContent(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        AlcoholicScreen()
    }
}