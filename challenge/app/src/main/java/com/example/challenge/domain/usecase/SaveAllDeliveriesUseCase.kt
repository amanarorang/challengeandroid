package com.example.challenge.domain.usecase

import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.domain.repository.DeliveryRepository
import kotlinx.coroutines.flow.Flow

class SaveAllDeliveriesUseCase(private val deliveryRepository: DeliveryRepository){
    suspend fun execute(deliveryResponseItem: List<DeliveryResponseItem>) {
        return deliveryRepository.saveAllDeliveries(deliveryResponseItem)
    }
}