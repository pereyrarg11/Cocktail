package com.pereyrarg11.cocktail.home.data.repository

import com.pereyrarg11.cocktail.home.data.provider.HomeSectionProvider
import com.pereyrarg11.cocktail.home.data.repository.model.HomeSectionContent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeSectionsRepository @Inject constructor(
    private val sectionsProvider: HomeSectionProvider,
) {

    fun getAllSections(): Flow<List<HomeSectionContent>> = flow {
        emit(sectionsProvider.sections)
    }
}