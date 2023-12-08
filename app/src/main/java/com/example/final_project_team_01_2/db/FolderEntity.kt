package com.example.final_project_team_01_2.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FolderEntity(
    @PrimaryKey(autoGenerate = true) val folderId: Long = 0,
    @ColumnInfo(name = "folder_name") val folderName: String
)
