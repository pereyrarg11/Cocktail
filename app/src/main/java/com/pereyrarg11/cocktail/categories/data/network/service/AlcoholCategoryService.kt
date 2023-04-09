package com.pereyrarg11.cocktail.categories.data.network.service

import com.pereyrarg11.cocktail.categories.data.network.client.AlcoholCategoryClient
import com.pereyrarg11.cocktail.categories.data.network.model.schema.CocktailListSchema
import com.pereyrarg11.cocktail.categories.ui.model.CocktailModel
import com.pereyrarg11.cocktail.data.Converter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AlcoholCategoryService @Inject constructor(
    private val apiClient: AlcoholCategoryClient,
    private val converter: Converter<CocktailListSchema, List<CocktailModel>>,
) {

    suspend fun filterCocktailListByAlcoholCategory(category: String): List<CocktailModel> {
        return withContext(Dispatchers.IO) {
            val responseBody = apiClient.requestByCategory(category).body()

            if (responseBody != null) {
                converter.convert(responseBody)
            } else {
                emptyList()
            }
        }
    }
}