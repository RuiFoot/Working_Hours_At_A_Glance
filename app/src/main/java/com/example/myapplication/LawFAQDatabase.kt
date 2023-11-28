package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.io.FileOutputStream
import java.io.IOException

@Database(entities = [LawFAQ::class], version = 2)
abstract class LawFAQDatabase : RoomDatabase() {
    abstract fun lawFAQDao(): LawFAQDao

    companion object {
        private var instance: LawFAQDatabase? = null

        fun getInstance(context: Context): LawFAQDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): LawFAQDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                LawFAQDatabase::class.java,
                "lawfaq_database"
            )
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        copyDatabaseFromAssets(context, "lawfaq.db", db)
                    }
                })
                .build()
        }

        private fun copyDatabaseFromAssets(context: Context, databaseName: String, db: SupportSQLiteDatabase) {
            try {
                val inputStream = context.assets.open(databaseName)
                val outputStream = FileOutputStream(db.path)
                val buffer = ByteArray(8192)
                var length: Int
                while (inputStream.read(buffer).also { length = it } > 0) {
                    outputStream.write(buffer, 0, length)
                }
                outputStream.flush()
                outputStream.close()
                inputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}