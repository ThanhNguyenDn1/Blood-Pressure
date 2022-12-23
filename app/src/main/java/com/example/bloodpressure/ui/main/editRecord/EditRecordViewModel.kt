package com.example.bloodpressure.ui.main.editRecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.bloodpressure.R
import com.example.bloodpressure.base.BaseViewModel
import com.example.bloodpressure.data.Preferences
import com.example.bloodpressure.data.database.BloodPressureRepository
import com.example.bloodpressure.data.database.note.NoteRepository
import com.example.bloodpressure.data.model.BloodPressure
import com.example.bloodpressure.data.model.Note
import com.example.bloodpressure.utils.Constant.ITEMS_EDITED
import com.example.bloodpressure.utils.listStringToJson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditRecordViewModel @Inject constructor(private val reposBlo: BloodPressureRepository, private val reposNote: NoteRepository, private val pref: Preferences) :
    BaseViewModel() {

    private var data: LiveData<List<BloodPressure>>
    private var notes: LiveData<List<Note>>
    private var itemUpdate: MutableLiveData<BloodPressure>
    private var stage = "Normal"
    private var systolic = 100
    private var diastolic = 75
    private var pulse = 70
    private var record_time = ""
    private var data_changes_time = 0L
    private var other_text = ""

    var items: List<Int> = arrayListOf(
        R.string.bq_tag_left,
        R.string.bq_tag_right,
        R.string.bq_tag_after_medication,
        R.string.bq_tag_after_walking,
        R.string.bq_tag_before_meal,
        R.string.bq_tag_after_meal,
        R.string.bq_tag_sitting,
        R.string.bq_tag_lying,
        R.string.legend_period
    )

    init {
        data = reposBlo.readAllData
        notes = reposNote.readAllNote
        itemUpdate = MutableLiveData()
    }

    fun addNewBloodPressure() {
        val bloodPressure = getBloodPressure(System.currentTimeMillis())
        viewModelScope.launch(Dispatchers.IO) {
            reposBlo.addBloodPressure(bloodPressure)
        }
    }

    fun updateBloodPressure() {
        viewModelScope.launch(Dispatchers.IO) {
            reposBlo.updateItemBloodPressure(getBloodPressure(itemUpdate.value!!.IdByInsertTime))
        }
    }

    fun deleteBloodPressure(bloodPressure: BloodPressure) {
        viewModelScope.launch(Dispatchers.IO) {
            reposBlo.deleteBloodPressure(bloodPressure)
        }
    }

    fun deleteById(idByInsertTime: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            reposBlo.deleteById(idByInsertTime)
        }
    }

    fun getItemByID(idByInsertTime: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            itemUpdate.postValue(reposBlo.getItemById(idByInsertTime))
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

    fun setDataBloodP(datas: ArrayList<Int>) {
        this.systolic = datas[0]
        this.diastolic = datas[1]
        this.pulse = datas[2]
    }

    fun setStage(string: String) {
        this.stage = string
    }

    fun setTimeRecord(dates: ArrayList<String>) {
        record_time = dates.listStringToJson()
    }

    fun setNote(itemNoteSelected: ArrayList<String>) {
        this.other_text = itemNoteSelected.listStringToJson()
    }

    fun getItemUpdate() = itemUpdate

    fun isEnoughtSave(): Boolean {
        return this.systolic > this.diastolic
    }

    fun isSaveItemDefault() = pref.getBoolen(false, ITEMS_EDITED)

    fun saveNoteDefault(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            reposNote.addNote(note)
        }
    }

    fun setSavedNotesDefault() {
        pref.SaveBoolen(true, ITEMS_EDITED)
    }

    fun getNotes()=notes

    fun getNotesDefault() = items
}