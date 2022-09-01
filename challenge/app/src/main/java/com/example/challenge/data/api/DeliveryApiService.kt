package com.example.challenge.data.api

import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DeliveryApiService {
    @GET("/deliveries")
    suspend fun getDeliveryData(@Query(value = "offset")offset:Int,@Query(value = "limit")limit:Int):Response<DeliveryResponse>
}