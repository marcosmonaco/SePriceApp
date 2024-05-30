package com.sepriceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterSuccessActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_success)
        enableEdgeToEdge()

        // Register button
        val continueButton = findViewById<Button>(R.id.continue_register)
        val continueIntent = Intent(this, MainMenuActivity::class.java)
        continueButton.setOnClickListener {
            startActivity(continueIntent)
        }
    }
}