package com.sepriceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LaboratoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.laboratory)
        enableEdgeToEdge()

        // Go back button
        val goBackButton = findViewById<Button>(R.id.goBackButton)
        val goBackIntent = Intent(this, MainMenuActivity::class.java)
        goBackButton.setOnClickListener {
            startActivity(goBackIntent)
        }
    }
}