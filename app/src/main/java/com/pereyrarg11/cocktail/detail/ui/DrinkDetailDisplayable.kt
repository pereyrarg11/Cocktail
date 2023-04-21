package com.pereyrarg11.cocktail.detail.ui

data class DrinkDetailDisplayable(
    val name: String = "",
    val alcohol: String = "",
    val category: String = "",
    val glass: String = "",
    val imageUrl: String = "",
    val imageCopyright: String = "",
    val ingredients: List<String> = emptyList(),
    val instructions: String = "",
)
