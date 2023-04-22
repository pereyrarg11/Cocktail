package com.pereyrarg11.cocktail.categories.domain

import com.pereyrarg11.cocktail.categories.data.repository.CategoriesRepository
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryWrapperContent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoriesRepository,
) {

    operator fun invoke(): Flow<List<CategoryWrapperContent>> = repository.getAllCategories()
}