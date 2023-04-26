package com.pereyrarg11.cocktail.filteredDrinks.data.network.service

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.filteredDrinks.data.network.client.FilterClient
import com.pereyrarg11.cocktail.filteredDrinks.data.network.model.DrinkListSchema
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.DrinkContent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class FilteredDrinksService @Inject constructor(
    private val apiClient: FilterClient,
    private val converter: Converter<DrinkListSchema, List<DrinkContent>>,
) {

    suspend fun filterDrinksByAlcohol(query: String): List<DrinkContent> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.filterDrinksByAlcohol(query)
            handleResponse(response)
        }
    }

    suspend fun filterDrinksByCategory(query: String): List<DrinkContent> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.filterDrinksByCategory(query)
            handleResponse(response)
        }
    }

    private fun handleResponse(response: Response<DrinkListSchema>): List<DrinkContent> {
        val body = response.body()

        return if (body != null) {
            converter.convert(body)
        } else {
            emptyList()
        }
    }
}