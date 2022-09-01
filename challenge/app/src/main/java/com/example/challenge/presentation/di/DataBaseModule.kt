package com.example.challenge.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.challenge.data.db.DeliveryDAO
import com.example.challenge.data.db.DeliveryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideDeliveryDatabase(app: Application): DeliveryDatabase {
        return Room.databaseBuilder(app, DeliveryDatabase::class.java, "delivery_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDeliveryDao(deliveryDatabase: DeliveryDatabase): DeliveryDAO {
        return deliveryDatabase.getDeliveryDAO()
    }


}