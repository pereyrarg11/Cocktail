package com.pereyrarg11.cocktail.categories.data.repository

import com.pereyrarg11.cocktail.categories.data.provider.CategoryWrapperProvider
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryWrapperContent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val categoryWrapperProvider: CategoryWrapperProvider
) {

    fun getAllCategories(): Flow<List<CategoryWrapperContent>> = flow {
        emit(categoryWrapperProvider.categoryWrappers)
    }
}