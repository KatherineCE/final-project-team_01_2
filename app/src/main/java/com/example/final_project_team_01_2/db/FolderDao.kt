package com.example.final_project_team_01_2.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FolderDao {
    @Insert
    fun insertFolder(folder: FolderEntity)

    @Query("SELECT * FROM FolderEntity")
    fun getAllFolders(): List<FolderEntity>
}