package com.example.bloodpressure.data.database.note

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bloodpressure.data.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}