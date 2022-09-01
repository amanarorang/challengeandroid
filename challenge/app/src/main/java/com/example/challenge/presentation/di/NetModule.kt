package com.example.challenge.presentation.di





import com.example.challenge.data.api.DeliveryApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
         return Retrofit.Builder()
             .addConverterFactory(GsonConverterFactory.create())
             .baseUrl("https://6285f87796bccbf32d6c0e6a.mockapi.io")
             .build()
    }

    @Singleton
    @Provides
    fun provideDeliveryAPIService(retrofit: Retrofit):DeliveryApiService{
        return retrofit.create(DeliveryApiService::class.java)
    }



}













