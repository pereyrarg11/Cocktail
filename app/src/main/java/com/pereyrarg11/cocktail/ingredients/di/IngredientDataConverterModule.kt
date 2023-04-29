package com.pereyrarg11.cocktail.ingredients.di

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.common.data.repository.model.FilterContent
import com.pereyrarg11.cocktail.ingredients.data.network.model.IngredientResponseSchema
import com.pereyrarg11.cocktail.ingredients.data.network.model.IngredientSchema
import com.pereyrarg11.cocktail.ingredients.data.repository.model.converter.IngredientContentConverter
import com.pereyrarg11.cocktail.ingredients.data.repository.model.converter.IngredientContentListConverter
import com.pereyrarg11.cocktail.ingredients.data.repository.model.converter.IngredientResponseConverter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class IngredientDataConverterModule {

    @Binds
    abstract fun bindIngredientContentConverter(
        converter: IngredientContentConverter
    ): Converter<IngredientSchema, FilterContent>

    @Binds
    abstract fun bindsIngredientContentListConverter(
        converter: IngredientContentListConverter
    ): Converter<List<IngredientSchema>, List<FilterContent>>

    @Binds
    abstract fun bindsIngredientResponseConverter(
        converter: IngredientResponseConverter
    ): Converter<IngredientResponseSchema, List<FilterContent>>
}