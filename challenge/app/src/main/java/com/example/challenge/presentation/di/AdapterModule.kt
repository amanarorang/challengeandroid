package com.example.challenge.presentation.di

import com.example.challenge.presentation.adapter.DeliveryAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
   @Singleton
   @Provides
   fun provideDeliveryAdapter():DeliveryAdapter{
       return DeliveryAdapter()
   }
}