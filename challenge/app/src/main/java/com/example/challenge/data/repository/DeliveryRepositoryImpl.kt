package com.example.challenge.data.repository

import com.example.challenge.data.model.DeliveryAndFavorite
import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.model.Favorite
import com.example.challenge.data.repository.dataSource.DeliveryLocalDataSource
import com.example.challenge.data.repository.dataSource.DeliveryRemoteDataSource
import com.example.challenge.data.util.Resource
import com.example.challenge.domain.repository.DeliveryRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class DeliveryRepositoryImpl(private val deliveryRemoteDataSource: DeliveryRemoteDataSource,private val deliveryLocalDataSource: DeliveryLocalDataSource):DeliveryRepository {


    private fun responseToResource(response:Response<DeliveryResponse>):Resource<DeliveryResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun deliveryRepository(offset: Int, limit: Int):Resource<DeliveryResponse> {
        return responseToResource(
            deliveryRemoteDataSource.getDeliveryList(offset,limit))
    }

    override suspend fun saveFavDelivery(favorite: Favorite) {
       deliveryLocalDataSource.saveFavoriteToDB(favorite)
    }

    override fun getDeliveryList(): List<DeliveryAndFavorite> {
        return deliveryLocalDataSource.getSavedDeliveries()
    }

    override suspend fun saveAllDeliveries(deliveryResponseItem: List<DeliveryResponseItem>) {
        deliveryLocalDataSource.saveAllDeliveries(deliveryResponseItem)
    }
}