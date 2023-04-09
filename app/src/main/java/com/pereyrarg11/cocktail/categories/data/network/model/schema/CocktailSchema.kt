package com.pereyrarg11.cocktail.categories.data.network.model.schema

import com.google.gson.annotations.SerializedName

data class CocktailSchema(
    @SerializedName("strDrink")
    val strDrink: String?,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String?,
    @SerializedName("idDrink")
    val idDrink: String?,
)
