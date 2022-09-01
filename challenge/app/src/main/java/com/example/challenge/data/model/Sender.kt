package com.example.challenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Sender(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String
):Serializable