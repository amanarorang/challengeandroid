package com.example.challenge.domain.usecase

import com.example.challenge.data.model.DeliveryAndFavorite
import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.domain.repository.DeliveryRepository
import kotlinx.coroutines.flow.Flow


class GetDeliveryListUseCase(private val deliveryRepository: DeliveryRepository) {
    suspend fun execute(): List<DeliveryAndFavorite>{
        return deliveryRepository.getDeliveryList()
    }
}