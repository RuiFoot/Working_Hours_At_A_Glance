package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [WorkHour::class], version = 1)
abstract class WorkHoursDatabase: RoomDatabase() {
    abstract fun workHourDao(): WorkHourDao
    companion object{
        @Volatile
        private var Instance:WorkHoursDatabase? = null
        fun getInstance(context:Context):WorkHoursDatabase{
            return Instance?: synchronized(this){
                Instance?: Room.databaseBuilder(
                    context.applicationContext,
                    WorkHoursDatabase::class.java, "workhours_database"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}