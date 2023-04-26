package com.pereyrarg11.cocktail.filteredDrinks.domain

import com.pereyrarg11.cocktail.filteredDrinks.data.repository.AlcoholFilterRepository
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.DrinkContent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDrinksByAlcoholUseCase @Inject constructor(
    private val repository: AlcoholFilterRepository,
) {

    operator fun invoke(query: String): Flow<List<DrinkContent>> =
        repository.getDrinksByAlcohol(query)
}