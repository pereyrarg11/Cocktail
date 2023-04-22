package com.pereyrarg11.cocktail.home.data.repository

import com.pereyrarg11.cocktail.home.data.network.AlcoholicCategory
import com.pereyrarg11.cocktail.home.data.network.service.AlcoholCategoryService
import com.pereyrarg11.cocktail.home.ui.model.CocktailModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AlcoholCategoryRepository @Inject constructor(
    private val api: AlcoholCategoryService,
) {

    fun getAlcoholicCocktailList(): Flow<List<CocktailModel>> = flow {
        emit(
            api.filterCocktailListByAlcoholCategory(AlcoholicCategory.ALCOHOLIC.description)
        )
    }
}