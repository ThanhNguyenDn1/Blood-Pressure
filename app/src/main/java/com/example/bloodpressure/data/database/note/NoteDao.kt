package com.example.bloodpressure.data.database.note

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.bloodpressure.data.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM note_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM note_table WHERE  id = :id")
    suspend fun deleteById(id: Int)

    @Query("SELECT * FROM note_table WHERE  id = :id")
    suspend fun getItemById(id: Int): Note
}