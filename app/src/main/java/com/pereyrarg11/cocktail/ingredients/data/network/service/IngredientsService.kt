package com.pereyrarg11.cocktail.ingredients.data.network.service

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.common.data.repository.model.FilterContent
import com.pereyrarg11.cocktail.ingredients.data.network.client.IngredientsClient
import com.pereyrarg11.cocktail.ingredients.data.network.model.IngredientResponseSchema
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class IngredientsService @Inject constructor(
    private val apiClient: IngredientsClient,
    private val converter: Converter<IngredientResponseSchema, List<FilterContent>>,
) {

    suspend fun getIngredients(): List<FilterContent> {
        return withContext(Dispatchers.IO) {
            val body = apiClient.getIngredients().body()

            if (body != null) {
                converter.convert(body)
            } else {
                emptyList()
            }
        }
    }
}