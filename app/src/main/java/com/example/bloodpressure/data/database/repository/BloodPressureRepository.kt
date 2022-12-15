package com.example.bloodpressure.data.database.repository

import androidx.lifecycle.LiveData
import com.example.bloodpressure.data.database.BloodPressureDao
import com.example.bloodpressure.data.model.BloodPressure
import javax.inject.Inject

class BloodPressureRepository @Inject constructor(private val dao: BloodPressureDao) {
    val readAllData: LiveData<List<BloodPressure>> = dao.readAllData()

    suspend fun addBloodPressure(bloodPressure: BloodPressure) {
        dao.addBloodPressure(bloodPressure)
    }

    suspend fun updateItemBloodPressure(bloodPressure: BloodPressure) {
        dao.updateItemBloodPressure(bloodPressure)
    }

    suspend fun deleteBloodPressure(bloodPressure: BloodPressure) {
        dao.deleteBloodPressure(bloodPressure)
    }
}