package com.example.bloodpressure.ui.main.editRecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.bloodpressure.base.BaseViewModel
import com.example.bloodpressure.data.database.repository.BloodPressureRepository
import com.example.bloodpressure.data.model.BloodPressure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditRecordViewModel @Inject constructor(val repository: BloodPressureRepository) :
    BaseViewModel() {

    private var data: LiveData<List<BloodPressure>>
    var stage = "Normal"
    var systolic = 100
    var diastolic = 75
    var pulse = 70
    var record_time = ""
    var data_changes_time = 0
    var other_text = ""

    init {
        data = repository.readAllData
    }

    fun addBloodPressure(bloodPressure: BloodPressure) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBloodPressure(bloodPressure)
        }
    }

    fun updateBloodPressure(bloodPressure: BloodPressure) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBloodPressure(bloodPressure)
        }
    }

    fun deleteBloodPressure(bloodPressure: BloodPressure) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteBloodPressure(bloodPressure)
        }
    }
}