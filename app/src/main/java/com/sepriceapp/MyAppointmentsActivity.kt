package com.sepriceapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.sepriceapp.data.comunes.FirestoreConstante
import java.text.SimpleDateFormat

class MyAppointmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_appointments)
        enableEdgeToEdge()


        val db = FirebaseFirestore.getInstance()

        val specialty = findViewById<TextView>(R.id.specialty)
        val professional = findViewById<TextView>(R.id.professional)
        val appointment_date = findViewById<TextView>(R.id.appointment_date)

        val docRef = db.collection(FirestoreConstante.COLECCION_TURNOS).document("001")
        docRef.get()
            .addOnSuccessListener { document ->

                if (document != null) {
                    Log.d("exists" , "DocumentSnapshot data: ${document.data}")

                    specialty.text = document.getString("especialidad")
                    professional.text = document.getString("profesional")

                    val timestamp = document.getTimestamp("fechaTurno")
                    if (timestamp != null) {
                        val date = timestamp.toDate()
                        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        val formattedDate = formatter.format(date)
                        appointment_date.text = formattedDate
                    } else {
                        appointment_date.text = "No appointment date"
                    }
                } else {
                    Log.d("does not exist", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("errordb", "get failed with ", exception)
            }



        // Go back button
        val goBackButton = findViewById<Button>(R.id.goBackButton)
        val goBackIntent = Intent(this, MainMenuActivity::class.java)
        goBackButton.setOnClickListener {
            startActivity(goBackIntent)
        }
    }
}