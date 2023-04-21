package com.pereyrarg11.cocktail.detail.di

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.detail.data.network.model.converter.DrinkDetailSchemaConverter
import com.pereyrarg11.cocktail.detail.data.network.model.converter.DrinkDetailWrapperSchemaConverter
import com.pereyrarg11.cocktail.detail.data.network.model.schema.DrinkDetailSchema
import com.pereyrarg11.cocktail.detail.data.network.model.schema.DrinkDetailWrapperSchema
import com.pereyrarg11.cocktail.detail.data.repository.model.content.DrinkDetailContent
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SchemaConverterModule {

    @Binds
    abstract fun bindsDrinkDetailSchemaConverter(converter: DrinkDetailSchemaConverter): Converter<DrinkDetailSchema, DrinkDetailContent>

    @Binds
    abstract fun bindsDrinkDetailWrapperSchemaConverter(converter: DrinkDetailWrapperSchemaConverter): Converter<DrinkDetailWrapperSchema, DrinkDetailContent>
}