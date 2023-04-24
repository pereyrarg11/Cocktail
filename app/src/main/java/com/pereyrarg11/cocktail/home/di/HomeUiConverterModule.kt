package com.pereyrarg11.cocktail.home.di

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.home.data.repository.model.AlcoholContent
import com.pereyrarg11.cocktail.home.data.repository.model.CategoryContent
import com.pereyrarg11.cocktail.home.data.repository.model.HomeSectionContent
import com.pereyrarg11.cocktail.home.ui.model.AlcoholDisplayable
import com.pereyrarg11.cocktail.home.ui.model.CategoryDisplayable
import com.pereyrarg11.cocktail.home.ui.model.HomeSectionDisplayable
import com.pereyrarg11.cocktail.home.ui.model.converter.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeUiConverterModule {

    @Binds
    abstract fun bindsAlcoholDisplayableConverter(
        converter: AlcoholDisplayableConverter
    ): Converter<AlcoholContent, AlcoholDisplayable>

    @Binds
    abstract fun bindsAlcoholDisplayableListConverter(
        converter: AlcoholDisplayableListConverter
    ): Converter<List<AlcoholContent>, List<AlcoholDisplayable>>

    @Binds
    abstract fun bindsHomeSectionDisplayableConverter(
        converter: HomeSectionDisplayableConverter
    ): Converter<HomeSectionContent, HomeSectionDisplayable>

    @Binds
    abstract fun bindsHomeSectionDisplayableListConverter(
        converter: HomeSectionDisplayableListConverter
    ): Converter<List<HomeSectionContent>, List<HomeSectionDisplayable>>

    @Binds
    abstract fun bindsCategoryDisplayableConverter(
        converter: CategoryDisplayableConverter
    ): Converter<CategoryContent, CategoryDisplayable>

    @Binds
    abstract fun bindsCategoryDisplayableListConverter(
        converter: CategoryDisplayableListConverter
    ): Converter<List<CategoryContent>, List<CategoryDisplayable>>
}