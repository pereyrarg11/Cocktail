package com.pereyrarg11.cocktail.categories.di

import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryContent
import com.pereyrarg11.cocktail.categories.data.repository.model.CategoryWrapperContent
import com.pereyrarg11.cocktail.categories.ui.model.CategoryDisplayable
import com.pereyrarg11.cocktail.categories.ui.model.CategoryWrapperDisplayable
import com.pereyrarg11.cocktail.categories.ui.model.converter.CategoryDisplayableConverter
import com.pereyrarg11.cocktail.categories.ui.model.converter.CategoryDisplayableListConverter
import com.pereyrarg11.cocktail.categories.ui.model.converter.CategoryWrapperDisplayableConverter
import com.pereyrarg11.cocktail.categories.ui.model.converter.CategoryWrapperDisplayableListConverter
import com.pereyrarg11.cocktail.common.data.Converter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CategoryConverterModule {

    /* UI Layer */
    @Binds
    abstract fun bindsCategoryDisplayableConverter(
        converter: CategoryDisplayableConverter
    ): Converter<CategoryContent, CategoryDisplayable>

    @Binds
    abstract fun bindsCategoryDisplayableListConverter(
        converter: CategoryDisplayableListConverter
    ): Converter<List<CategoryContent>, List<CategoryDisplayable>>

    @Binds
    abstract fun bindsCategoryWrapperDisplayableConverter(
        converter: CategoryWrapperDisplayableConverter
    ): Converter<CategoryWrapperContent, CategoryWrapperDisplayable>

    @Binds
    abstract fun bindsCategoryWrapperDisplayableListConverter(
        converter: CategoryWrapperDisplayableListConverter
    ): Converter<List<CategoryWrapperContent>, List<CategoryWrapperDisplayable>>
}