package com.pereyrarg11.cocktail.home.data

enum class CategoryFilterType(val query: String) {
    COCKTAIL("Cocktail"),
    SHAKE("Shake"),
    SHOT("Shot"),
    BEER("Beer"),
    COFFEE_AND_TEA("Coffee_/_Tea"),
    MORE("more"),
    UNKNOWN("");
}