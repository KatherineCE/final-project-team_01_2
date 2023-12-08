package com.example.final_project_team_01_2.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FolderEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun folderDao(): FolderDao
}