package com.example.challenge.domain.usecase

import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.model.Favorite
import com.example.challenge.domain.repository.DeliveryRepository

class SaveFavDeliveryUseCase(private val deliveryRepository: DeliveryRepository) {
   suspend fun execute(favorite:Favorite)=deliveryRepository.saveFavDelivery(favorite)
}