package com.pereyrarg11.cocktail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pereyrarg11.cocktail.common.data.FilterType
import com.pereyrarg11.cocktail.common.ui.navigation.Arguments
import com.pereyrarg11.cocktail.common.ui.navigation.Routes
import com.pereyrarg11.cocktail.detail.ui.DrinkDetailScreen
import com.pereyrarg11.cocktail.filteredDrinks.ui.FilteredDrinksScreen
import com.pereyrarg11.cocktail.home.ui.HomeScreen
import com.pereyrarg11.cocktail.ingredients.ui.IngredientsScreen
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
        /*
        * more details about navigation
        * https://developer.android.com/jetpack/compose/navigation
        * https://developer.android.com/jetpack/compose/libraries#hilt-navigation
        * */
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routes.HomeScreen.route,
        ) {
            composable(Routes.HomeScreen.route) { HomeScreen(navController) }

            composable(
                route = Routes.CocktailDetailScreen.route,
                arguments = listOf(
                    navArgument(Arguments.ID.label) { type = NavType.StringType }
                )
            ) { navBackStackEntry ->
                DrinkDetailScreen(
                    cocktailId = navBackStackEntry.arguments?.getString(Arguments.ID.label) ?: "",
                    navController = navController,
                )
            }

            composable(
                route = Routes.AlcoholDrinksScreen.route,
                arguments = listOf(
                    navArgument(Arguments.QUERY.label) { type = NavType.StringType },
                    navArgument(Arguments.TITLE.label) { type = NavType.StringType },
                )
            ) { navBackStackEntry ->
                FilteredDrinksScreen(
                    query = navBackStackEntry.arguments?.getString(Arguments.QUERY.label) ?: "",
                    title = navBackStackEntry.arguments?.getString(Arguments.TITLE.label) ?: "",
                    filterType = FilterType.ALCOHOL,
                    navHostController = navController
                )
            }

            composable(
                route = Routes.CategoryDrinksScreen.route,
                arguments = listOf(
                    navArgument(Arguments.QUERY.label) { type = NavType.StringType },
                    navArgument(Arguments.TITLE.label) { type = NavType.StringType },
                )
            ) { navBackStackEntry ->
                FilteredDrinksScreen(
                    query = navBackStackEntry.arguments?.getString(Arguments.QUERY.label) ?: "",
                    title = navBackStackEntry.arguments?.getString(Arguments.TITLE.label) ?: "",
                    filterType = FilterType.CATEGORY,
                    navHostController = navController
                )
            }

            composable(
                route = Routes.IngredientDrinksScreen.route,
                arguments = listOf(
                    navArgument(Arguments.QUERY.label) { type = NavType.StringType },
                    navArgument(Arguments.TITLE.label) { type = NavType.StringType },
                )
            ) { navBackStackEntry ->
                FilteredDrinksScreen(
                    query = navBackStackEntry.arguments?.getString(Arguments.QUERY.label) ?: "",
                    title = navBackStackEntry.arguments?.getString(Arguments.TITLE.label) ?: "",
                    filterType = FilterType.INGREDIENT,
                    navHostController = navController
                )
            }

            composable(Routes.IngredientsScreen.route) { IngredientsScreen(navController) }
        }
    }
}