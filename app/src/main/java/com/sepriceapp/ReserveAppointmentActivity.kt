package com.sepriceapp


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ReserveAppointmentActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reserve_appointments)
        enableEdgeToEdge()

        //Spinners

        // Especialidades
        val items_especialidades = resources.getStringArray(R.array.dropdown_especialidades)

        val especialidades = findViewById<Spinner>(R.id.spinner_especialidades)
        if (especialidades != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, items_especialidades
            )
            especialidades.adapter = adapter
        }

        // Profesionales
        val items_profesionales = resources.getStringArray(R.array.dropdown_profesionales)
        val profesionales = findViewById<Spinner>(R.id.spinner_profesionales)
        if (profesionales != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, items_profesionales
            )
            profesionales.adapter = adapter
        }

        // Fechas
        val items_fechas = resources.getStringArray(R.array.dropdown_fechas)
        val fechas = findViewById<Spinner>(R.id.spinner_fechas)
        if (fechas != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, items_fechas
            )
            fechas.adapter = adapter
        }

        // Horarios
        val items_horarios = resources.getStringArray(R.array.dropdown_horarios)
        val horarios = findViewById<Spinner>(R.id.spinner_horarios)
        if (horarios != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, items_horarios
            )
            horarios.adapter = adapter
        }

        // confirm button
        val confirmButton = findViewById<Button>(R.id.confirmButton)
        val confirmIntent = Intent(this, MyAppointmentsActivity::class.java)
        confirmButton.setOnClickListener {
            startActivity(confirmIntent)
        }

        // Go back button
        val goBackButton = findViewById<Button>(R.id.goBackButton)
        val goBackIntent = Intent(this, MainMenuActivity::class.java)
        goBackButton.setOnClickListener {
            startActivity(goBackIntent)
        }
    }
}