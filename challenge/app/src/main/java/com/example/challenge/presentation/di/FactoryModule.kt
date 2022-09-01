package com.example.challenge.presentation.di

import android.app.Application
import com.example.challenge.domain.usecase.GetDeliveriesUseCase
import com.example.challenge.domain.usecase.GetDeliveryListUseCase
import com.example.challenge.domain.usecase.SaveAllDeliveriesUseCase
import com.example.challenge.domain.usecase.SaveFavDeliveryUseCase
import com.example.challenge.presentation.viewmodel.DeliveryViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
  fun provideDeliveryViewModelFactory(
        application: Application,
        getDeliveriesUseCase: GetDeliveriesUseCase,
        saveFavDeliveryUseCase: SaveFavDeliveryUseCase,
        getDeliveryListUseCase: GetDeliveryListUseCase,
        saveAllDeliveriesUseCase:SaveAllDeliveriesUseCase
  ):DeliveryViewModelFactory{
      return DeliveryViewModelFactory(
          application,
          getDeliveriesUseCase,getDeliveryListUseCase,saveFavDeliveryUseCase,
          saveAllDeliveriesUseCase
      )
  }
}








