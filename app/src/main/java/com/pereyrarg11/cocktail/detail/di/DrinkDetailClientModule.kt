package com.pereyrarg11.cocktail.detail.di

import com.pereyrarg11.cocktail.detail.data.network.client.DrinkDetailClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DrinkDetailClientModule {

    @Singleton
    @Provides
    fun providesDrinkDetailClient(retrofit: Retrofit): DrinkDetailClient =
        retrofit.create(DrinkDetailClient::class.java)
}