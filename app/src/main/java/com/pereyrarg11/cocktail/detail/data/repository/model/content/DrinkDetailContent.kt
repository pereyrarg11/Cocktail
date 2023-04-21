package com.pereyrarg11.cocktail.detail.data.repository.model.content

data class DrinkDetailContent(
    val id: String = "",
    val name: String = "",
    val imageUrl: String = "",
    val imageCopyright: String = "",
    val glass: String = "",
    val category: String = "",
    val alcoholCategory: AlcoholDrinkCategory = AlcoholDrinkCategory.UNKNOWN,
    val measuredIngredients: List<String> = emptyList(),
    val instructions: String = "",
)
