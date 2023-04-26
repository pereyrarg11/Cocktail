package com.pereyrarg11.cocktail.filteredDrinks.data.network.service

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.filteredDrinks.data.network.client.FilterClient
import com.pereyrarg11.cocktail.filteredDrinks.data.network.model.DrinkListSchema
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.DrinkContent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilteredDrinksService @Inject constructor(
    private val apiClient: FilterClient,
    private val converter: Converter<DrinkListSchema, List<DrinkContent>>,
) {

    suspend fun filterDrinksByAlcohol(query: String): List<DrinkContent> {
        return withContext(Dispatchers.IO) {
            val responseBody = apiClient.filterDrinksByAlcohol(query).body()

            if (responseBody != null) {
                converter.convert(responseBody)
            } else {
                emptyList()
            }
        }
    }
}