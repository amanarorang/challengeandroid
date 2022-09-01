package com.example.challenge.domain.usecase

import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.util.Resource
import com.example.challenge.domain.repository.DeliveryRepository
import retrofit2.Response

class GetDeliveriesUseCase(private val deliveryRepo: DeliveryRepository){
      suspend fun execute(offset:Int,limit:Int):Resource<DeliveryResponse>{
          return deliveryRepo.deliveryRepository(offset,limit)
      }

}