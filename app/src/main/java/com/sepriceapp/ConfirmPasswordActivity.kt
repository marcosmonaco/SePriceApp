package com.sepriceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ConfirmPasswordActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password)
        enableEdgeToEdge()

        // Register button
        val continueButton = findViewById<Button>(R.id.register_button)
        val continueIntent = Intent(this, RegisterSuccessActivity::class.java)
        continueButton.setOnClickListener {
            startActivity(continueIntent)
        }
    }
}