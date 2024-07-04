package com.sepriceapp.data.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant

class PatientModel {
    var nombre: String = ""
    var apellido: String = ""
    var email: String = ""
    var dni: String = ""
    var telefono: String  = ""
    @RequiresApi(Build.VERSION_CODES.O)
    var fechaNacimiento: Instant = Instant.now()
    var ciudad: String = ""
    var localidad: String = ""
    var direccion: String = ""
    var obraSocial: String = ""
    var afiliado: Number = 0


}