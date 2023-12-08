package com.example.final_project_team_01_2.db

import android.content.Context
import androidx.room.Room

object DatabaseInitializer {
    private var instance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        return instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }
    }

    private fun buildDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "qa-database"
        ).build()
    }
}
