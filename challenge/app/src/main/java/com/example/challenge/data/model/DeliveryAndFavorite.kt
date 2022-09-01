package com.example.challenge.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class DeliveryAndFavorite(@Embedded val deliveryResponseItem: DeliveryResponseItem,
                               @Relation(
                                   parentColumn = "id",
                                   entityColumn = "userId"
                               )
                               val favorite: Favorite?)
