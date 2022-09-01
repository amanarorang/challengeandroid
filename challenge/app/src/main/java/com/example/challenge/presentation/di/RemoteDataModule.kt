package com.example.challenge.presentation.di


import com.example.challenge.data.api.DeliveryApiService
import com.example.challenge.data.repository.dataSource.DeliveryRemoteDataSource
import com.example.challenge.data.repository.dataSourceImpl.DeliveryRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        deliveryApiService: DeliveryApiService
    ):DeliveryRemoteDataSource{
       return DeliveryRemoteDataSourceImpl(deliveryApiService)
    }

}












