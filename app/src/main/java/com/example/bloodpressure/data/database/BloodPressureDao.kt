package com.example.bloodpressure.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.bloodpressure.data.model.BloodPressure

@Dao
interface BloodPressureDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBloodPressure(bloodPressure: BloodPressure)

    @Query("SELECT * FROM blood_pressure_table ORDER BY IdByInsertTime ASC")
    fun readAllData(): LiveData<List<BloodPressure>>

    @Update
    suspend fun updateItemBloodPressure(bloodPressure: BloodPressure)

    @Delete
    suspend fun deleteBloodPressure(bloodPressure: BloodPressure)

    @Query("DELETE FROM blood_pressure_table WHERE  IdByInsertTime = :idByInsertTime")
    suspend fun deleteById(idByInsertTime:Long)

    @Query("SELECT * FROM blood_pressure_table WHERE  IdByInsertTime = :idByInsertTime")
    suspend fun getItemById(idByInsertTime:Long):BloodPressure

}