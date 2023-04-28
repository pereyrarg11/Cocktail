package com.pereyrarg11.cocktail.common.ui.navigation

sealed class Routes(val route: String) {

    object HomeScreen : Routes("home")

    object CocktailDetailScreen : Routes("drink/{id}") {

        fun createRoute(id: String) = "drink/$id"

    }

    object AlcoholDrinksScreen : Routes("alcohol/drinks?query={query}&title={title}") {

        fun createRoute(query: String, title: String) = "alcohol/drinks?query=$query&title=$title"

    }

    object CategoryDrinksScreen: Routes("categories/drinks?query={query}&title={title}") {

        fun createRoute(query: String, title: String) = "categories/drinks?query=$query&title=$title"

    }

    object IngredientDrinksScreen : Routes("ingredients/drinks?query={query}&title={title}") {

        fun createRoute(query: String, title: String) = "ingredients/drinks?query=$query&title=$title"

    }
}