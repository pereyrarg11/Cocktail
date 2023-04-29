package com.pereyrarg11.cocktail.ingredients.data.network.model

import com.google.gson.annotations.SerializedName

data class IngredientResponseSchema(
    @SerializedName("drinks")
    val drinks: List<IngredientSchema>?,
)
