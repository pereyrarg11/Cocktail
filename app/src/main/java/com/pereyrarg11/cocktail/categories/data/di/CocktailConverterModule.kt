package com.pereyrarg11.cocktail.categories.data.di

import com.pereyrarg11.cocktail.categories.data.network.model.converter.CocktailConverter
import com.pereyrarg11.cocktail.categories.data.network.model.converter.CocktailListConverter
import com.pereyrarg11.cocktail.categories.data.network.model.schema.CocktailListSchema
import com.pereyrarg11.cocktail.categories.data.network.model.schema.CocktailSchema
import com.pereyrarg11.cocktail.categories.ui.model.CocktailModel
import com.pereyrarg11.cocktail.common.data.Converter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CocktailConverterModule {

    @Binds
    abstract fun bindsCocktailConverter(converter: CocktailConverter): Converter<CocktailSchema, CocktailModel>

    @Binds
    abstract fun bindCocktailListConverter(converter: CocktailListConverter): Converter<CocktailListSchema, List<CocktailModel>>
}