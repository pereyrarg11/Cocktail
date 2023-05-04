package com.pereyrarg11.cocktail.ingredients.data.repository

import com.pereyrarg11.cocktail.common.data.repository.model.FilterContent
import com.pereyrarg11.cocktail.ingredients.data.network.service.IngredientsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class IngredientsRepository @Inject constructor(
    private val api: IngredientsService,
) {

    fun getIngredients(): Flow<List<FilterContent>> = flow {
        emit(api.getIngredients())
    }
}