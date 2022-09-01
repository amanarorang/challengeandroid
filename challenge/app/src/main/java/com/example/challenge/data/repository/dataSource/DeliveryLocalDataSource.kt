package com.example.challenge.data.repository.dataSource


import com.example.challenge.data.model.DeliveryAndFavorite
import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.model.Favorite
import kotlinx.coroutines.flow.Flow

interface DeliveryLocalDataSource {
    suspend fun saveFavoriteToDB(favorite: Favorite)
    fun getSavedDeliveries(): List<DeliveryAndFavorite>
    suspend fun saveAllDeliveries(deviceResponseItem: List<DeliveryResponseItem>)




}