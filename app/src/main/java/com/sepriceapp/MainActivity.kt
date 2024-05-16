package com.sepriceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    package com.example.myapp

    import android.os.Bundle
    import android.widget.ArrayAdapter
    import android.widget.Spinner
    import androidx.appcompat.app.AppCompatActivity

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.inicio)

            // Obtener referencia al Spinner
            val spinner: Spinner = findViewById(R.id.spinner)

            // Crear un ArrayAdapter usando el array de strings y el layout por defecto del spinner
            ArrayAdapter.createFromResource(
                this,
                R.array.dropdown_items,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Especificar el layout a usar cuando la lista de opciones aparece
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Aplicar el adapter al spinner
                spinner.adapter = adapter
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)

        val button = findViewById<Button>(R.id.button)

        val intent = Intent(this, MainActivity2::class.java)

        button.setOnClickListener {
            startActivity(intent)
        }
    }

}