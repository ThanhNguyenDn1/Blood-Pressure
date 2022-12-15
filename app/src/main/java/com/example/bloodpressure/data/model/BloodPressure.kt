package com.example.bloodpressure.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blood_pressure_table")
data class BloodPressure(
    @PrimaryKey() val IdByInsertTime: Long,
    @ColumnInfo(name = "stage") val stage: String,
    @ColumnInfo(name = "systolic") val systolic: Int,
    @ColumnInfo(name = "diastolic") val diastolic: Int,
    @ColumnInfo(name = "pulse") val pulse: Int,
    @ColumnInfo(name = "record_time") val record_time: String,
    @ColumnInfo(name = "data_changes_time") val data_changes_time: Long,
    @ColumnInfo(name = "other_text") val other_text: String,
    )