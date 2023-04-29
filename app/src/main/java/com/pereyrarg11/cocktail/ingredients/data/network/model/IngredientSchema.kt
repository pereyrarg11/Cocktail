package com.pereyrarg11.cocktail.ingredients.data.network.model

import com.google.gson.annotations.SerializedName

data class IngredientSchema(
    @SerializedName("strIngredient1")
    val strIngredient1: String?,
)