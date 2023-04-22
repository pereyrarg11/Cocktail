package com.pereyrarg11.cocktail.categories.di

import com.pereyrarg11.cocktail.categories.data.repository.model.AlcoholContent
import com.pereyrarg11.cocktail.categories.data.repository.model.HomeSectionContent
import com.pereyrarg11.cocktail.categories.ui.model.AlcoholDisplayable
import com.pereyrarg11.cocktail.categories.ui.model.HomeSectionDisplayable
import com.pereyrarg11.cocktail.categories.ui.model.converter.AlcoholDisplayableConverter
import com.pereyrarg11.cocktail.categories.ui.model.converter.AlcoholDisplayableListConverter
import com.pereyrarg11.cocktail.categories.ui.model.converter.HomeSectionDisplayableConverter
import com.pereyrarg11.cocktail.categories.ui.model.converter.HomeSectionDisplayableListConverter
import com.pereyrarg11.cocktail.common.data.Converter
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
}