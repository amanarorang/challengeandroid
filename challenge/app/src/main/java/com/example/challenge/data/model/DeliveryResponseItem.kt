package com.example.challenge.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(
    tableName = "delivery"
)
data class DeliveryResponseItem(
    @SerializedName("deliveryFee")
    val deliveryFee: String,
    @SerializedName("goodsPicture")
    val goodsPicture: String,
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("pickupTime")
    val pickupTime: String,
    @SerializedName("remarks")
    val remarks: String,
    @Embedded
    @SerializedName("route")
    val route: Route,
    @Embedded
    @SerializedName("sender")
    val sender: Sender,
    @SerializedName("surcharge")
    val surcharge: String
):Serializable