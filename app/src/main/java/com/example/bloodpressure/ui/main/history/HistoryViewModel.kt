package com.example.bloodpressure.ui.main.history

import androidx.lifecycle.LiveData
import com.example.bloodpressure.base.BaseViewModel
import com.example.bloodpressure.data.database.repository.BloodPressureRepository
import com.example.bloodpressure.data.model.BloodPressure
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val repository: BloodPressureRepository) :
    BaseViewModel() {

    private var data: LiveData<List<BloodPressure>>

    init {
        data = repository.readAllData
    }

    fun getData() = data
}