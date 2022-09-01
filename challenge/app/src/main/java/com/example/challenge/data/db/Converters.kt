package com.example.challenge.data.db

import androidx.room.TypeConverter
import com.example.challenge.data.model.Route
import com.example.challenge.data.model.Sender
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromRoute(route: Route):String{
        val type = object : TypeToken<Route>() {}.type
        return Gson().toJson(route, type)
    }
    @TypeConverter
    fun toRoute(route:String):Route{
        val type = object : TypeToken<Route>() {}.type
        return Gson().fromJson<Route>(route, type)
    }
    @TypeConverter
    fun fromSender(sender: Sender):String{
        val type = object : TypeToken<Sender>() {}.type
        return Gson().toJson(sender, type)
    }
    @TypeConverter
    fun toSender(sender:String):Sender{
        val type = object : TypeToken<Sender>() {}.type
        return Gson().fromJson<Sender>(sender, type)
    }
}
