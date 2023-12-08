package com.example.final_project_team_01_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.view.View
import android.view.KeyEvent
import android.util.Log
import android.widget.Toast

const val TAG = "AddFolderActivity"

class AddFolderActivity : AppCompatActivity() {

    private lateinit var newFolderText: EditText
    private lateinit var newFolderButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_folder)

        newFolderButton = findViewById(R.id.NewFolderButton)

        newFolderButton.setOnClickListener{
            newFolderText = findViewById(R.id.NewFolderText)
            var folderName = newFolderText.text
            Toast.makeText(this, folderName, Toast.LENGTH_SHORT).show()
        }
    }
}