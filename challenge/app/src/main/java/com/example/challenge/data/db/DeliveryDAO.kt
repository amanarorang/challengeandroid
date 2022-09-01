package com.example.challenge.data.db

import androidx.room.*
import com.example.challenge.data.model.DeliveryAndFavorite
import com.example.challenge.data.model.DeliveryResponse
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.model.Favorite
import kotlinx.coroutines.flow.Flow

@Dao
interface DeliveryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: Favorite)
    @Query("SELECT * FROM delivery")
    fun getAllDeliveries(): List<DeliveryAndFavorite>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveAllDeliveries(deliveryResponseItem: List<DeliveryResponseItem>)




}