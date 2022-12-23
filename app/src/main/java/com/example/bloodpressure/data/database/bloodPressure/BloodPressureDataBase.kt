package com.example.bloodpressure.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bloodpressure.data.model.BloodPressure

@Database(entities = [BloodPressure::class], version = 1, exportSchema = false)
abstract class BloodPressureDataBase : RoomDatabase() {
    abstract fun bloodPressureDao():BloodPressureDao
}