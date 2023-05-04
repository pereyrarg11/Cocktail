package com.pereyrarg11.cocktail.ingredients.data.network.client

import com.pereyrarg11.cocktail.ingredients.data.network.model.IngredientResponseSchema
import retrofit2.Response
import retrofit2.http.GET

interface IngredientsClient {

    @GET("list.php?i=list")
    suspend fun getIngredients(): Response<IngredientResponseSchema>
}