package com.pereyrarg11.cocktail.filteredDrinks.data.network.model

import com.google.gson.annotations.SerializedName

data class DrinkListSchema(
    @SerializedName("drinks")
    val drinks: List<DrinkSchema>?,
)
