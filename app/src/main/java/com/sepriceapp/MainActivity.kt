package com.sepriceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        // Login button
        val loginButton = findViewById<Button>(R.id.loginButton)
        val loginIntent = Intent(this, MainMenuActivity::class.java)
        loginButton.setOnClickListener {
            startActivity(loginIntent)
        }

        // Register button
        val registerButton = findViewById<TextView>(R.id.start_no_account)
        val registerIntent = Intent(this, RegisterActivity::class.java)
        registerButton.setOnClickListener {
            startActivity(registerIntent)
        }





    }

}