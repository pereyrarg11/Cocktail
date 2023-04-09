package com.pereyrarg11.cocktail.categories.data.network.client

import com.pereyrarg11.cocktail.categories.data.network.model.schema.CocktailListSchema
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlcoholCategoryClient {

    @GET("filter.php")
    suspend fun requestByCategory(
        @Query("a") category: String,
    ): Response<CocktailListSchema>
}