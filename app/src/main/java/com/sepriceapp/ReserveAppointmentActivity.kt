package com.sepriceapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ReserveAppointmentActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reserve_appointments)
        enableEdgeToEdge()

       // Go back button
        val goBackButton = findViewById<Button>(R.id.goBackButton)
        val goBackIntent = Intent(this, MainMenuActivity::class.java)
        goBackButton.setOnClickListener {
            startActivity(goBackIntent)
        }
    }
}