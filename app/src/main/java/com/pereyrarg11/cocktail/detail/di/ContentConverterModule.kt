package com.pereyrarg11.cocktail.detail.di

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.detail.data.repository.model.content.DrinkDetailContent
import com.pereyrarg11.cocktail.detail.data.repository.model.converter.DrinkDetailContentConverter
import com.pereyrarg11.cocktail.detail.ui.DrinkDetailDisplayable
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ContentConverterModule {

    @Binds
    abstract fun bindsDrinkDetailContentConverter(converter: DrinkDetailContentConverter): Converter<DrinkDetailContent, DrinkDetailDisplayable>
}