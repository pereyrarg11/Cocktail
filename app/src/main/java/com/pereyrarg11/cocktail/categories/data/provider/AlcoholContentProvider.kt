package com.pereyrarg11.cocktail.categories.data.provider

import com.pereyrarg11.cocktail.categories.data.AlcoholFilterType
import com.pereyrarg11.cocktail.categories.data.repository.model.AlcoholContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlcoholContentProvider @Inject constructor() {

    val alcoholItems = AlcoholFilterType
        .values()
        .filter { it != AlcoholFilterType.UNKNOWN }
        .map { AlcoholContent(type = it) }
}