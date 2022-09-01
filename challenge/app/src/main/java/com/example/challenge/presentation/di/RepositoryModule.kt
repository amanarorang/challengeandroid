package com.example.challenge.presentation.di


import com.example.challenge.data.repository.DeliveryRepositoryImpl
import com.example.challenge.data.repository.dataSource.DeliveryLocalDataSource
import com.example.challenge.data.repository.dataSource.DeliveryRemoteDataSource
import com.example.challenge.domain.repository.DeliveryRepository
import com.example.challenge.domain.usecase.GetDeliveryListUseCase
import com.example.challenge.domain.usecase.SaveFavDeliveryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDeliveryRepository(
        deliveryRemoteDataSource: DeliveryRemoteDataSource,
        deliveryLocalDataSource: DeliveryLocalDataSource
    ):DeliveryRepository{
        return DeliveryRepositoryImpl(deliveryRemoteDataSource,deliveryLocalDataSource)
    }

}














