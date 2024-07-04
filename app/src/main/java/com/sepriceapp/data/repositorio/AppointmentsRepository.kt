package com.sepriceapp.data.repositorio

import android.os.Build
import androidx.annotation.RequiresApi
import com.sepriceapp.data.comunes.FirestoreConstante
import com.sepriceapp.data.comunes.FirestoreInstance
import com.sepriceapp.data.model.AppointmentModel
import com.sepriceapp.data.model.ProfessionalModel
import kotlinx.coroutines.tasks.await

class AppointmentsRepository {
    suspend fun listar(dato: String): List<AppointmentModel> {
        return FirestoreInstance.get().collection(FirestoreConstante.COLECCION_TURNOS)
            .orderBy("id").startAt(dato).endAt(dato + "\uf8ff")
            .get().await().toObjects(AppointmentModel::class.java)
    }

    private suspend fun registrar(model: AppointmentModel): Boolean {
        val turnos = FirestoreInstance.get().collection(FirestoreConstante.COLECCION_TURNOS).document()
        model.id = turnos.id
        turnos.set(model).await()
        return true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private suspend fun actualizar(model: AppointmentModel): Boolean{
        val turno = FirestoreInstance.get().collection(FirestoreConstante.COLECCION_TURNOS).document(model.id)
        turno.update(
            mapOf("especialidad" to model.especialidad,
                "estado" to model.estado,
                "fechaHorario" to model.fechaHorario,
                "profesional" to model.profesional)
        ).await()
        return true
    }

    suspend fun eliminar(model: AppointmentModel): Boolean{
        val turno = FirestoreInstance.get().collection(FirestoreConstante.COLECCION_TURNOS).document(model.id)
        turno.delete().await()
        return true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun grabar(model: AppointmentModel): Boolean{
        return if(model.id.isEmpty()){
            registrar(model)
        } else {
            actualizar(model)
        }
    }
}