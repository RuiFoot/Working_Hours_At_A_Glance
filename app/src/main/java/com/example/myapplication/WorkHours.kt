package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "work_hours")
data class WorkHour(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String,
    val startTime: Long,
    val endTime: Long
)