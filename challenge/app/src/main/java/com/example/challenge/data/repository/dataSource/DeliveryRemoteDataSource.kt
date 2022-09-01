package com.example.challenge.data.repository.dataSource


import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.util.Resource
import retrofit2.Response

interface DeliveryRemoteDataSource{
    suspend fun getDeliveryList(offset:Int,limit:Int): Response<DeliveryResponse>
}