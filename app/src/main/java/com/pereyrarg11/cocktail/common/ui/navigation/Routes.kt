package com.pereyrarg11.cocktail.common.ui.navigation

sealed class Routes(val route: String) {

    object CocktailsScreen : Routes("cocktails")

    object CocktailDetailScreen : Routes("cocktails/{id}") {
        fun createRoute(id: String) = "cocktails/$id"
    }
}