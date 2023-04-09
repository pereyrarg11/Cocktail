package com.pereyrarg11.cocktail.categories.alcoholic.domain

import com.pereyrarg11.cocktail.categories.data.repository.AlcoholCategoryRepository
import com.pereyrarg11.cocktail.categories.ui.model.CocktailModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAlcoholicCocktailListUseCase @Inject constructor(
    private val repository: AlcoholCategoryRepository,
) {

    operator fun invoke(): Flow<List<CocktailModel>> = repository.getAlcoholicCocktailList()
}