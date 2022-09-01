package com.example.challenge.presentation.di



import com.example.challenge.data.db.DeliveryDAO
import com.example.challenge.data.db.DeliveryDatabase
import com.example.challenge.data.repository.dataSource.DeliveryLocalDataSource
import com.example.challenge.data.repository.dataSourceImpl.DeliveryLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(deliveryDAO: DeliveryDAO):DeliveryLocalDataSource{
      return DeliveryLocalDataSourceImpl(deliveryDAO)
    }

}













