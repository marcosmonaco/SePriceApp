package com.sepriceapp.data.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant

class StudiesModel {
    @RequiresApi(Build.VERSION_CODES.O)
    var fecha:  Instant = Instant.now()
    var id: String = ""
    var nombre: String = ""
    var tipo: String =""
}