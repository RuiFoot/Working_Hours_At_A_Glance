package com.example.myapplication

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lawfaq")
data class LawFAQ(
    @PrimaryKey(autoGenerate = true)  val id: Int?,
    @ColumnInfo(name = "law_no")
    val lawNo: Int?,

    @ColumnInfo(name = "main")
    val main: String?,

    @ColumnInfo(name = "middle")
    val middle: String?,

    @ColumnInfo(name = "small")
    val small: String?,

    @ColumnInfo(name = "question")
    val question: String?,

    @ColumnInfo(name = "answer")
    val answer: String?
)
