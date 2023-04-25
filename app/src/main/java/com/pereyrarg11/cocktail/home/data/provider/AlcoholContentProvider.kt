package com.pereyrarg11.cocktail.home.data.provider

import com.pereyrarg11.cocktail.home.data.AlcoholFilterType
import com.pereyrarg11.cocktail.home.data.repository.model.AlcoholContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlcoholContentProvider @Inject constructor() {

    val alcoholItems = AlcoholFilterType
        .values()
        .filter { it != AlcoholFilterType.UNKNOWN }
        .map { AlcoholContent(type = it) }
}