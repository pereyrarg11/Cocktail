package com.pereyrarg11.cocktail.home.data

enum class IngredientFilterType(val query: String) {
    GIN("Gin"),
    SCOTCH("Scotch"),
    BRANDY("Brandy"),
    CHAMPAGNE("Champagne"),
    TEQUILA("Tequila"),
    VODKA("Vodka"),
    KAHLUA("Kahlua"),
    WHISKEY("Whiskey"),
    COGNAC("Cognac"),
    PISCO("Pisco"),
    MORE("more"),
    UNKNOWN("");
}