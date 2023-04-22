package com.pereyrarg11.cocktail.categories.domain

import com.pereyrarg11.cocktail.categories.data.repository.HomeSectionsRepository
import com.pereyrarg11.cocktail.categories.data.repository.model.HomeSectionContent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHomeSectionsUseCase @Inject constructor(
    private val repository: HomeSectionsRepository,
) {

    operator fun invoke(): Flow<List<HomeSectionContent>> = repository.getAllSections()
}