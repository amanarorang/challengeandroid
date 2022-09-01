package com.example.challenge.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.model.Favorite
import com.example.challenge.data.model.Route

@Database(
    entities = [DeliveryResponseItem::class,Favorite::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract  class DeliveryDatabase : RoomDatabase(){
    abstract fun getDeliveryDAO():DeliveryDAO
}

