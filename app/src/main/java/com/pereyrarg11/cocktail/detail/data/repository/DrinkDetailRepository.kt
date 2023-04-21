package com.pereyrarg11.cocktail.detail.data.repository

import com.pereyrarg11.cocktail.detail.data.network.service.DrinkDetailService
import com.pereyrarg11.cocktail.detail.data.repository.model.content.DrinkDetailContent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DrinkDetailRepository @Inject constructor(
    private val service: DrinkDetailService,
) {

    fun getDrinkById(id: String): Flow<DrinkDetailContent> = flow {
        emit(service.requestById(id))
    }
}