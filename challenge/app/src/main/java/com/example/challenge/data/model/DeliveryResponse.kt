package com.example.challenge.data.model

import androidx.room.Entity
import androidx.room.TypeConverter

@Entity (tableName = "deliveryResponse")
class DeliveryResponse:ArrayList<DeliveryResponseItem>()

