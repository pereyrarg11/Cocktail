package com.pereyrarg11.cocktail.filteredDrinks.data.network.model

import com.google.gson.annotations.SerializedName

data class DrinkSchema(
    @SerializedName("strDrink")
    val strDrink: String?,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String?,
    @SerializedName("idDrink")
    val idDrink: String?,
)
