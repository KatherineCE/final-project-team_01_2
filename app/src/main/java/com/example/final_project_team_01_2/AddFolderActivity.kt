package com.example.final_project_team_01_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import com.example.final_project_team_01_2.db.AppDatabase

import com.example.final_project_team_01_2.db.DatabaseInitializer
import com.example.final_project_team_01_2.db.FolderEntity
import com.example.final_project_team_01_2.db.FolderDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class AddFolderActivity : AppCompatActivity() {

    private lateinit var newFolderText: EditText
    private lateinit var newFolderButton:Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_folder)

        newFolderText = findViewById(R.id.NewFolderText)
        newFolderButton = findViewById(R.id.NewFolderButton)

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).build()

        newFolderButton.setOnClickListener{
            val folderName = newFolderText.text.toString()

            if (folderName.isNotEmpty()) {
                GlobalScope.launch(Dispatchers.IO) {
                    val folder = FolderEntity(folderName = folderName)
                    database.folderDao().insertFolder(folder)
                    showToast("Folder added successfully")
                }
            } else {
                showToast("Please enter a folder name")
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
