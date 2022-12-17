package com.example.bloodpressure.ui.main.editRecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    private var itemUpdate: MutableLiveData<BloodPressure>
    private var stage = "Normal"
    private var systolic = 100
    private var diastolic = 75
    private var pulse = 70
    private var record_time = ""
    private var data_changes_time = 0L
    private var other_text = ""

    init {
        data = repository.readAllData
        itemUpdate = MutableLiveData()
    }

    fun addNewBloodPressure() {
        val bloodPressure = getBloodPressure(System.currentTimeMillis())
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBloodPressure(bloodPressure)
        }
    }

    fun updateBloodPressure() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateItemBloodPressure(getBloodPressure(itemUpdate.value!!.IdByInsertTime))
        }
    }

    fun deleteBloodPressure(bloodPressure: BloodPressure) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteBloodPressure(bloodPressure)
        }
    }

    fun deleteById(idByInsertTime: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteById(idByInsertTime)
        }
    }

    fun getItemByID(idByInsertTime: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            itemUpdate.postValue(repository.getItemById(idByInsertTime))
        }
    }

    fun getBloodPressure(idByInsertTime: Long): BloodPressure {
        return BloodPressure(
            IdByInsertTime = idByInsertTime,
            stage = stage,
            systolic = systolic,
            diastolic = diastolic,
            pulse = pulse,
            record_time = record_time,
            data_changes_time = data_changes_time,
            other_text = other_text
        )
    }

    fun setDataBloodP(datas:ArrayList<Int>) {
        this.systolic = datas[0]
        this.diastolic = datas[1]
        this.pulse = datas[2]
    }

    fun setStage(string: String) {
        this.stage = string
    }

    fun setTimeRecord(dates: ArrayList<String>) {
        record_time = dates.stringsToJson()
    }

    fun setNote(itemNoteSelected: ArrayList<String>) {
        this.other_text = itemNoteSelected.stringsToJson()
    }

    fun getItemUpdate() = itemUpdate
}