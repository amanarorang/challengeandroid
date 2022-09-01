package com.example.challenge.domain.repository

import com.example.challenge.data.model.DeliveryAndFavorite
import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.model.Favorite
import com.example.challenge.data.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface DeliveryRepository {
    suspend fun deliveryRepository(offset:Int,limit:Int): Resource<DeliveryResponse>
    suspend fun saveFavDelivery(favorite: Favorite)
    fun getDeliveryList(): List<DeliveryAndFavorite>
    suspend fun saveAllDeliveries(deliveryResponseItem: List<DeliveryResponseItem>)
}
