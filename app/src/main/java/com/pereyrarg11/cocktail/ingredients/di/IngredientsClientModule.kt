package com.pereyrarg11.cocktail.ingredients.di

import com.pereyrarg11.cocktail.ingredients.data.network.client.IngredientsClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object IngredientsClientModule {

    @Singleton
    @Provides
    fun providesIngredientsClient(retrofit: Retrofit): IngredientsClient =
        retrofit.create(IngredientsClient::class.java)
}