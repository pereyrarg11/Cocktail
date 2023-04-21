package com.pereyrarg11.cocktail.detail.data.network.model.schema

import com.google.gson.annotations.SerializedName

data class DrinkDetailWrapperSchema(
    @SerializedName("drinks")
    val drinks: List<DrinkDetailSchema>?,
)
