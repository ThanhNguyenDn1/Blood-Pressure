package com.example.bloodpressure.data.database.note


import androidx.lifecycle.LiveData
import com.example.bloodpressure.data.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val dao: NoteDao) {
    val readAllNote: LiveData<List<Note>> = dao.readAllData()
    suspend fun addNote(note: Note) {
        dao.addNote(note)
    }

    suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }

    suspend fun deleteById(id: Int) {
        dao.deleteById(id)
    }

    suspend fun getById(id: Int) = dao.getItemById(id)
}