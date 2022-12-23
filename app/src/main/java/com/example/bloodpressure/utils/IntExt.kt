package com.example.bloodpressure.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


fun ArrayList<Int>.listIntToJson(): String {
    val gson = Gson()
    return gson.toJson(this)
}

fun String.jsonToListInt(): ArrayList<Int> {
    val gson = Gson()
    return if (this.isEmpty()) {
        ArrayList()
    } else {
        val type = object : TypeToken<List<Int?>?>() {}.type
        gson.fromJson(this, type)
    }
}

