package com.pereyrarg11.cocktail.home.domain

import com.pereyrarg11.cocktail.home.data.repository.AlcoholCategoryRepository
import com.pereyrarg11.cocktail.home.ui.model.CocktailModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAlcoholicCocktailListUseCase @Inject constructor(
    private val repository: AlcoholCategoryRepository,
) {

    operator fun invoke(): Flow<List<CocktailModel>> = repository.getAlcoholicCocktailList()
}