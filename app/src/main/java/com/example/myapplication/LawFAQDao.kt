package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LawFAQDao {
    @Query("SELECT * FROM lawfaq;")
    fun getAllFAQs(): List<LawFAQ>

}