package com.example.challenge.data.repository.dataSourceImpl


import com.example.challenge.data.db.DeliveryDAO
import com.example.challenge.data.model.DeliveryAndFavorite
import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.model.Favorite
import com.example.challenge.data.repository.dataSource.DeliveryLocalDataSource
import kotlinx.coroutines.flow.Flow

class DeliveryLocalDataSourceImpl(
    private val deliveryDAO: DeliveryDAO
) : DeliveryLocalDataSource {
    override suspend fun saveFavoriteToDB(favorite: Favorite) {
        deliveryDAO.insert(favorite)
    }


    override fun getSavedDeliveries(): List<DeliveryAndFavorite> {
        return deliveryDAO.getAllDeliveries()
    }

    override suspend fun saveAllDeliveries(deviceResponseItem: List<DeliveryResponseItem>) {
        deliveryDAO.saveAllDeliveries(deviceResponseItem)
    }

}