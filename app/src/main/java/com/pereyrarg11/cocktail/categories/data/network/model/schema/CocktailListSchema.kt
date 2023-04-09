package com.pereyrarg11.cocktail.categories.data.network.model.schema

import com.google.gson.annotations.SerializedName

data class CocktailListSchema(
    @SerializedName("drinks")
    val drinks: List<CocktailSchema>?,
)
