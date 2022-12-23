package com.example.bloodpressure.di

import android.content.Context
import androidx.room.Room
import com.example.bloodpressure.data.database.BloodPressureDao
import com.example.bloodpressure.data.database.BloodPressureDataBase
import com.example.bloodpressure.data.database.note.NoteDao
import com.example.bloodpressure.data.database.note.NoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideBloodPressureDataBase(@ApplicationContext context: Context): BloodPressureDataBase =
        Room.databaseBuilder(context, BloodPressureDataBase::class.java, "blood_pressure_table")
            .build()

    @Provides
    fun provideBloodPressureDao(dataBase: BloodPressureDataBase): BloodPressureDao =
        dataBase.bloodPressureDao()

    @Singleton
    @Provides
    fun provideNoteDataBase(@ApplicationContext context: Context): NoteDataBase =
        Room.databaseBuilder(context, NoteDataBase::class.java, "note_table").build()

    @Provides
    fun provideNoteDao(dataBase: NoteDataBase): NoteDao = dataBase.noteDao()

}