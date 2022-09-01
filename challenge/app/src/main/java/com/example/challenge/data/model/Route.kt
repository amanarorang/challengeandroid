package com.example.challenge.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Route(
    @SerializedName("end")
    val end: String,
    @SerializedName("start")
    val start: String
):Serializable