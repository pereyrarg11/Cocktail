package com.pereyrarg11.cocktail.detail.domain

import com.pereyrarg11.cocktail.detail.data.repository.DrinkDetailRepository
import com.pereyrarg11.cocktail.detail.data.repository.model.content.DrinkDetailContent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDrinkDetailsUseCase @Inject constructor(
    private val repository: DrinkDetailRepository,
) {

    operator fun invoke(id: String): Flow<DrinkDetailContent> = repository.getDrinkById(id)
}