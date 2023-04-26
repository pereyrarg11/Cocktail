package com.pereyrarg11.cocktail.filteredDrinks.di

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.DrinkContent
import com.pereyrarg11.cocktail.filteredDrinks.ui.model.DrinkDisplayable
import com.pereyrarg11.cocktail.filteredDrinks.ui.model.converter.DrinkDisplayableConverter
import com.pereyrarg11.cocktail.filteredDrinks.ui.model.converter.DrinkDisplayableListConverter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FilteredDrinksUiConverterModule {

    @Binds
    abstract fun bindsDrinkDisplayableConverter(
        converter: DrinkDisplayableConverter
    ): Converter<DrinkContent, DrinkDisplayable>

    @Binds
    abstract fun bindsDrinkDisplayableListConverter(
        converter: DrinkDisplayableListConverter
    ): Converter<List<DrinkContent>, List<DrinkDisplayable>>
}