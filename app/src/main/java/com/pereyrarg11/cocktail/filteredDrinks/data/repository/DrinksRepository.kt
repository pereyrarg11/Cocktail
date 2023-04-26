package com.pereyrarg11.cocktail.filteredDrinks.data.repository

import com.pereyrarg11.cocktail.filteredDrinks.data.network.service.FilteredDrinksService
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.DrinkContent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DrinksRepository @Inject constructor(
    private val api: FilteredDrinksService,
) {

    fun getDrinksByAlcohol(query: String): Flow<List<DrinkContent>> = flow {
        emit(api.filterDrinksByAlcohol(query))
    }

    fun getDrinksByCategory(query: String): Flow<List<DrinkContent>> = flow {
        emit(api.filterDrinksByCategory(query))
    }
}