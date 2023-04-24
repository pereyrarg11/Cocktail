package com.pereyrarg11.cocktail.home.data.repository.model

import com.pereyrarg11.cocktail.home.data.HomeSectionType

data class HomeSectionContent(
    val type: HomeSectionType = HomeSectionType.UNKNOWN,
    val alcoholItems: List<AlcoholContent> = emptyList(),
    val categoryItems: List<CategoryContent> = emptyList(),
)