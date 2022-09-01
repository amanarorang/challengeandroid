package com.example.challenge.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(
    tableName = "favorite"
)
data class Favorite(
    @PrimaryKey
    val userId:String,
    val isFavorite: Boolean
)
