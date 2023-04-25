package com.pereyrarg11.cocktail.home.domain

import com.pereyrarg11.cocktail.home.data.repository.HomeSectionsRepository
import com.pereyrarg11.cocktail.home.data.repository.model.HomeSectionContent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHomeSectionsUseCase @Inject constructor(
    private val repository: HomeSectionsRepository,
) {

    // TODO: set a random order for section items
    operator fun invoke(): Flow<List<HomeSectionContent>> = repository.getAllSections()
}