package com.example.bloodpressure.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


fun ArrayList<String>.listStringToJson(): String {
    val gson = Gson()
    return gson.toJson(this)
}

fun String.jsonToListString(): ArrayList<String> {
    val gson = Gson()
    return if (this.isEmpty()) {
        ArrayList()
    } else {
        val type = object : TypeToken<List<String?>?>() {}.type
        gson.fromJson(this, type)
    }
}


fun ArrayList<String>.toNotes(): String {
    var notes = ""
    this.forEach {
        notes = notes.plus(" #").plus(it)
    }
    return notes
}

fun String.formatToDate(): String {
    val list = this.jsonToListString()
    return "${list[1]}, ${list[2]}: ${list[3]}, "
}

fun Int.formatToBPM(): String {
    return "$this BPM"
}