package com.pereyrarg11.cocktail.home.data.provider

import com.pereyrarg11.cocktail.home.data.IngredientFilterType
import com.pereyrarg11.cocktail.home.data.repository.model.IngredientContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngredientContentProvider @Inject constructor() {

    val ingredients = IngredientFilterType.values()
        .filter { it != IngredientFilterType.UNKNOWN }
        .map { IngredientContent(type = it) }
}