package com.example.bloodpressure.data

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Preferences @Inject constructor(@ApplicationContext context: Context) {
    private val prefs = context.getSharedPreferences("app", Context.MODE_PRIVATE)
    private fun getPrefsEditer(): SharedPreferences.Editor {
        return prefs.edit()
    }

    fun SaveBoolen(value: Boolean, key: String) {
        getPrefsEditer().apply {
            this.putBoolean(key, value).commit()
        }
    }

    fun getBoolen(value: Boolean, key: String) = prefs.getBoolean(key, value)
}