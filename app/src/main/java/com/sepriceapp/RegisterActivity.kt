package com.sepriceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        enableEdgeToEdge()

        // Continue button
        val registerButton = findViewById<Button>(R.id.continueButton)
        val registerIntent = Intent(this, ConfirmPasswordActivity::class.java)
        registerButton.setOnClickListener {
            startActivity(registerIntent)
        }
    }
}