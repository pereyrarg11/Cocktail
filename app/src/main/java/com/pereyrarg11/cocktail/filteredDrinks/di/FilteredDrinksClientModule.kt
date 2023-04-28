package com.pereyrarg11.cocktail.filteredDrinks.di

import com.pereyrarg11.cocktail.filteredDrinks.data.network.client.FilterClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FilteredDrinksClientModule {

    @Singleton
    @Provides
    fun provideAlcoholCategoryClient(retrofit: Retrofit): FilterClient =
        retrofit.create(FilterClient::class.java)
}