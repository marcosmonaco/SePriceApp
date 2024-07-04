package com.sepriceapp.data.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.Timestamp
import java.time.Instant

class AppointmentModel {
    var id: String = ""
    var especialidad: String = ""
    var estado: String = ""
    var profesional: String = ""
    @RequiresApi(Build.VERSION_CODES.O)
    var fechaHorario: Instant = Instant.now()

}