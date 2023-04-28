package com.pereyrarg11.cocktail.filteredDrinks.di

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.filteredDrinks.data.network.model.DrinkListSchema
import com.pereyrarg11.cocktail.filteredDrinks.data.network.model.DrinkSchema
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.DrinkContent
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.converter.DrinkContentConverter
import com.pereyrarg11.cocktail.filteredDrinks.data.repository.model.converter.DrinkContentListConverter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FilteredDrinksDataConverterModule {

    @Binds
    abstract fun bindsDrinkContentConverter(
        converter: DrinkContentConverter
    ): Converter<DrinkSchema, DrinkContent>

    @Binds
    abstract fun bindsDrinkContentListConverter(
        converter: DrinkContentListConverter
    ): Converter<DrinkListSchema, List<DrinkContent>>
}