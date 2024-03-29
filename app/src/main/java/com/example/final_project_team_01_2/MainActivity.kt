package com.example.final_project_team_01_2
import com.google.firebase.FirebaseApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var foldersButton:Button
    private lateinit var estimatesButton:Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)


        foldersButton = findViewById(R.id.FoldersButton)
        estimatesButton = findViewById(R.id.EstimatesButton)
        exitButton = findViewById(R.id.ExitButton)

        foldersButton.setOnClickListener{ val intent1 = Intent (this, FoldersActivity::class.java)
                startActivity(intent1)
        }

        estimatesButton.setOnClickListener {
            // Intent to start APIActivity
            val intent = Intent(this@MainActivity, APIActivity::class.java)
            intent.putExtra("shouldFetchResults", true)
            startActivity(intent)
        }



        exitButton.setOnClickListener{
            println("Clicked")
        }
    }
}