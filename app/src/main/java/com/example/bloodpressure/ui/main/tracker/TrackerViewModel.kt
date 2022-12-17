package com.example.bloodpressure.ui.main.tracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.bloodpressure.base.BaseViewModel
import com.example.bloodpressure.data.database.BloodPressureRepository
import com.example.bloodpressure.data.model.BloodPressure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackerViewModel @Inject constructor(private val repository: BloodPressureRepository) :
    BaseViewModel() {
    private  var data: LiveData<List<BloodPressure>>
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

    fun getData() = data

}