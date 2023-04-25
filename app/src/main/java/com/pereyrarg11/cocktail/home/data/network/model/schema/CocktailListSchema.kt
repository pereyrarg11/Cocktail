package com.pereyrarg11.cocktail.home.data.network.model.schema

import com.google.gson.annotations.SerializedName

data class CocktailListSchema(
    @SerializedName("drinks")
    val drinks: List<CocktailSchema>?,
)
