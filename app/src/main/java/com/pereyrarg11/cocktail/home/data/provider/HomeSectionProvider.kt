package com.pereyrarg11.cocktail.home.data.provider

import com.pereyrarg11.cocktail.home.data.HomeSectionType
import com.pereyrarg11.cocktail.home.data.repository.model.HomeSectionContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeSectionProvider @Inject constructor(
    alcoholProvider: AlcoholContentProvider,
    categoryProvider: CategoryContentProvider,
    ingredientProvider: IngredientContentProvider,
) {

    val sections: List<HomeSectionContent> = listOf(
        HomeSectionContent(
            type = HomeSectionType.ALCOHOL,
            alcoholItems = alcoholProvider.alcoholItems
        ),
        HomeSectionContent(
            type = HomeSectionType.CATEGORIES,
            categoryItems = categoryProvider.categoryItems
        ),
        HomeSectionContent(
            type = HomeSectionType.INGREDIENTS,
            ingredientItems = ingredientProvider.ingredients
        )
    )
}