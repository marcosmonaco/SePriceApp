package com.sepriceapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainMenuActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)
        enableEdgeToEdge()

        // Reservar turno
        val reserveAppointmentButton = findViewById<Button>(R.id.reserveAppointment)
        val continueIntent = Intent(this, ReserveAppointmentActivity::class.java)
        reserveAppointmentButton.setOnClickListener {
            startActivity(continueIntent)
        }

        // Mis turnos
        val myAppointmentsButton = findViewById<Button>(R.id.myAppointments)
        val myAppointmentsIntent = Intent(this, MyAppointmentsActivity::class.java)
        myAppointmentsButton.setOnClickListener {
            startActivity(myAppointmentsIntent)
        }

        // Laboratorio
        val laboratoryButton = findViewById<Button>(R.id.laboratory)
        val laboratoryIntent = Intent(this, LaboratoryActivity::class.java)
        laboratoryButton.setOnClickListener {
            startActivity(laboratoryIntent)
        }

        // Estudios
        val studiesButton = findViewById<Button>(R.id.studies)
        val studiesIntent = Intent(this, StudiesActivity::class.java)
        studiesButton.setOnClickListener {
            startActivity(studiesIntent)
        }

        // Ayuda
        val helpButton = findViewById<Button>(R.id.help)
        val helpIntent = Intent(this, HelpActivity::class.java)
        helpButton.setOnClickListener {
            startActivity(helpIntent)
        }
    }
}