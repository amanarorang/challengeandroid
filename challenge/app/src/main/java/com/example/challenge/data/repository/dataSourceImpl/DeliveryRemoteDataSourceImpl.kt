package com.example.challenge.data.repository.dataSourceImpl

import com.example.challenge.data.api.DeliveryApiService
import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.repository.dataSource.DeliveryRemoteDataSource
import com.example.challenge.data.util.Resource
import retrofit2.Response

class DeliveryRemoteDataSourceImpl(private val deliveryApiService: DeliveryApiService):DeliveryRemoteDataSource {


    override suspend fun getDeliveryList(offset: Int, limit: Int): Response<DeliveryResponse> {
        return deliveryApiService.getDeliveryData(offset,limit)
    }
}