package com.pereyrarg11.cocktail.categories.data.repository.model

import com.pereyrarg11.cocktail.categories.data.HomeSectionType

data class HomeSectionContent(
    val type: HomeSectionType = HomeSectionType.UNKNOWN,
    val alcoholItems: List<AlcoholContent> = emptyList(),
)