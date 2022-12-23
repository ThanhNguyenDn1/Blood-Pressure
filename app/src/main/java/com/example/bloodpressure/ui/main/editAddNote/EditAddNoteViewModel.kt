package com.example.bloodpressure.ui.main.editAddNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.bloodpressure.base.BaseViewModel
import com.example.bloodpressure.data.Preferences
import com.example.bloodpressure.data.database.note.NoteRepository
import com.example.bloodpressure.data.model.Note
import com.example.bloodpressure.utils.Constant.ITEMS_EDITED
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditAddNoteViewModel @Inject constructor(
    private val pref: Preferences, private val repository: NoteRepository
) : BaseViewModel() {

    private var notes: LiveData<List<Note>>

    init {
        notes = repository.readAllNote
    }

    fun saveListDefault(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(note)
        }
    }

    fun getNotes() = notes

    fun isNoteExist(contentNote: String): Boolean {
        return notes.value!!.any { it.content.equals(contentNote) }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch(Dispatchers.IO)
        { repository.deleteNote(note) }
    }

}