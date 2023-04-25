package com.pereyrarg11.cocktail.home.data.di

import com.pereyrarg11.cocktail.home.data.network.client.AlcoholCategoryClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AlcoholCategoryClientModule {

    @Singleton
    @Provides
    fun provideAlcoholCategoryClient(retrofit: Retrofit): AlcoholCategoryClient =
        retrofit.create(AlcoholCategoryClient::class.java)
}