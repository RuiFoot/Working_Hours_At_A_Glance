package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LawFAQDao {
    @Query("SELECT * FROM LawFAQ WHERE (main = :searchMain OR :searchMain = '전체') AND (middle = :searchMiddle OR :searchMiddle = '전체') AND (question LIKE '%' || :editText || '%' OR :editText = '')")
    suspend fun searchFAQs(searchMain: String, searchMiddle: String, editText: String): List<LawFAQ>

}