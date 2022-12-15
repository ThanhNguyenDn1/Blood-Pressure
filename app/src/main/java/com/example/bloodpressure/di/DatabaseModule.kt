package com.example.bloodpressure.di

import android.content.Context
import androidx.room.Room
import com.example.bloodpressure.data.database.BloodPressureDao
import com.example.bloodpressure.data.database.BloodPressureDataBase
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


}