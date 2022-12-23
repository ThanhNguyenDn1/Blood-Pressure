package com.example.bloodpressure.ui.main.editAddNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.bloodpressure.R
import com.example.bloodpressure.base.BaseViewModel
import com.example.bloodpressure.data.Preferences
import com.example.bloodpressure.data.database.note.NoteRepository
import com.example.bloodpressure.data.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditAddNoteViewModel @Inject constructor(
    private val pref: Preferences, private val repository: NoteRepository
) : BaseViewModel() {
    private var ITEMS_EDITED = "item_edited"
    private var itemsEdited: LiveData<List<Note>>
    private var items: ArrayList<Int> = arrayListOf(
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
        itemsEdited = repository.readAllNote
    }

    fun saveListDefault(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(note)
        }
    }

    fun isSaveItemDefault() = pref.getBoolen(false, ITEMS_EDITED)

    fun savedItemsDefault() {
        pref.SaveBoolen(true, ITEMS_EDITED)
    }

    fun getItemsDefault() = items

    fun getItemsEdited() = itemsEdited

}