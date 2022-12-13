package com.example.bloodpressure.utils

import android.app.Activity
import android.content.Context
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ConfigScreen @Inject constructor(@ApplicationContext private val context: Context) {
    fun setStatusBar(activity: Activity, isDecorFitsSystem:Boolean,  color:Int) {
        WindowCompat.setDecorFitsSystemWindows(activity.window, isDecorFitsSystem)
        val window = activity.window
        window.statusBarColor = ContextCompat.getColor(activity, color)
    }
}