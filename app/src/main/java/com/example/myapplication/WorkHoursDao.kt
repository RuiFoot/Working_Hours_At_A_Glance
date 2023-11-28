package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WorkHourDao {
    @Insert
    fun insert(workHour: WorkHour)

    @Query("SELECT * FROM work_hours")
    fun getAllWorkHours(): List<WorkHour>
}