package com.pereyrarg11.cocktail.detail.data.network.client

import com.pereyrarg11.cocktail.detail.data.network.model.schema.DrinkDetailWrapperSchema
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkDetailClient {

    @GET("lookup.php")
    suspend fun requestById(@Query("i") id: String): Response<DrinkDetailWrapperSchema>
}