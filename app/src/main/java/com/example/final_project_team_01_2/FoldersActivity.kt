package com.example.final_project_team_01_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FoldersActivity : AppCompatActivity() {

    private lateinit var addFolderButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_folders)

        addFolderButton = findViewById(R.id.AddButton)


        addFolderButton.setOnClickListener{ val intent1 = Intent (this, AddFolderActivity::class.java)
            startActivity(intent1)
        }
    }
}