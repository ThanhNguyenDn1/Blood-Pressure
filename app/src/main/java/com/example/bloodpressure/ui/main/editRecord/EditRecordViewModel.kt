package com.example.bloodpressure.ui.main.editRecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.bloodpressure.base.BaseViewModel
import com.example.bloodpressure.data.database.BloodPressureRepository
import com.example.bloodpressure.data.model.BloodPressure
import com.example.bloodpressure.utils.stringsToJson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditRecordViewModel @Inject constructor(val repository: BloodPressureRepository) :
    BaseViewModel() {

    private var data: LiveData<List<BloodPressure>>
    private var stage = "Normal"
    private var systolic = 100
    private var diastolic = 75
    private var pulse = 70
    private var record_time = ""
    private var data_changes_time = 0L
    private var other_text = ""

    init {
        data = repository.readAllData
    }

    fun addNewBloodPressure() {
        val bloodPressure = getBloodPressure()
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

    fun getBloodPressure(): BloodPressure {
        return BloodPressure(
            IdByInsertTime = System.currentTimeMillis(),
            stage = stage,
            systolic = systolic,
            diastolic = diastolic,
            pulse = pulse,
            record_time = record_time,
            data_changes_time = data_changes_time,
            other_text = other_text
        )
    }

    fun setDataBloodP(systolic: Int, diastolic: Int, pulse: Int) {
        this.systolic = systolic
        this.diastolic = diastolic
        this.pulse = pulse
    }

    fun setStage(string: String) {
        this.stage = string
    }

    fun setTimeRecord(dates: Array<String>) {
        record_time = dates[1] + ", " + dates[2] + ":" + dates[3]
    }

    fun setNote(itemNoteSelected: ArrayList<String>) {
        this.other_text = itemNoteSelected.stringsToJson()
    }
}