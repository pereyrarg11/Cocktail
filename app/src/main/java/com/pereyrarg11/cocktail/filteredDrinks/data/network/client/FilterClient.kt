package com.pereyrarg11.cocktail.filteredDrinks.data.network.client

import com.pereyrarg11.cocktail.filteredDrinks.data.network.model.DrinkListSchema
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FilterClient {

    @GET("filter.php")
    suspend fun filterDrinksByAlcohol(
        @Query("a") query: String,
    ): Response<DrinkListSchema>
}