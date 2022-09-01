package com.example.challenge.presentation.di

import com.example.challenge.domain.repository.DeliveryRepository
import com.example.challenge.domain.usecase.GetDeliveriesUseCase
import com.example.challenge.domain.usecase.GetDeliveryListUseCase
import com.example.challenge.domain.usecase.SaveAllDeliveriesUseCase
import com.example.challenge.domain.usecase.SaveFavDeliveryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
   @Singleton
   @Provides
   fun provideGetDeliveriesUseCase(
       deliveryRepository: DeliveryRepository
   ):GetDeliveriesUseCase{
      return GetDeliveriesUseCase(deliveryRepository)
   }
   @Singleton
   @Provides
   fun provideGetDeliveryListUseCase(
      deliveryRepository: DeliveryRepository
   ):GetDeliveryListUseCase{
      return GetDeliveryListUseCase(deliveryRepository)
   }
   @Singleton
   @Provides
   fun provideSaveFavDeliveryUseCase(
      deliveryRepository: DeliveryRepository
   ):SaveFavDeliveryUseCase{
      return SaveFavDeliveryUseCase(deliveryRepository)
   }
   @Singleton
   @Provides
   fun provideSaveAllDeliveriesUseCase(
      deliveryRepository: DeliveryRepository
   ):SaveAllDeliveriesUseCase{
      return SaveAllDeliveriesUseCase(deliveryRepository)
   }
}


















