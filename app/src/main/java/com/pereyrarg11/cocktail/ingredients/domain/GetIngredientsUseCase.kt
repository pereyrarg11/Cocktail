package com.pereyrarg11.cocktail.ingredients.domain

import com.pereyrarg11.cocktail.common.data.repository.model.FilterContent
import com.pereyrarg11.cocktail.ingredients.data.repository.IngredientsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetIngredientsUseCase @Inject constructor(
    private val repository: IngredientsRepository,
) {

    operator fun invoke(): Flow<List<FilterContent>> = repository.getIngredients()
}