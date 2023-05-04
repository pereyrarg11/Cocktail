package com.pereyrarg11.cocktail.common.di

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.common.data.repository.model.FilterContent
import com.pereyrarg11.cocktail.common.ui.model.FilterDisplayable
import com.pereyrarg11.cocktail.common.ui.model.converter.FilterDisplayableConverter
import com.pereyrarg11.cocktail.common.ui.model.converter.FilterDisplayableListConverter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FilterUiConverterModule {

    @Binds
    abstract fun bindsFilterDisplayableConverter(
        converter: FilterDisplayableConverter
    ): Converter<FilterContent, FilterDisplayable>

    @Binds
    abstract fun bindsFilterDisplayableListConverter(
        converter: FilterDisplayableListConverter
    ): Converter<List<FilterContent>, List<FilterDisplayable>>
}