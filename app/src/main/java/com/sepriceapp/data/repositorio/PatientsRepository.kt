package com.sepriceapp.data.repositorio

import android.os.Build
import androidx.annotation.RequiresApi
import com.sepriceapp.data.comunes.FirestoreConstante
import com.sepriceapp.data.comunes.FirestoreInstance
import com.sepriceapp.data.model.AppointmentModel
import com.sepriceapp.data.model.PatientModel
import kotlinx.coroutines.tasks.await

class PatientsRepository {
    suspend fun listar(dato: String): List<PatientModel> {
        return FirestoreInstance.get().collection(FirestoreConstante.COLECCION_PACIENTES)
            .orderBy("dni").startAt(dato).endAt(dato + "\uf8ff")
            .get().await().toObjects(PatientModel::class.java)
    }

    private suspend fun registrar(model: PatientModel): Boolean {
        val pacientes = FirestoreInstance.get().collection(FirestoreConstante.COLECCION_PACIENTES).document()
        model.dni = pacientes.id
        pacientes.set(model).await()
        return true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private suspend fun actualizar(model: PatientModel): Boolean{
        val paciente = FirestoreInstance.get().collection(FirestoreConstante.COLECCION_PACIENTES).document(model.dni)
        paciente.update(
            mapOf("nombre" to model.nombre,
            "apellido" to model.apellido,
            "mail" to model.email,
            "dni" to model.dni,
            "telefono" to model.telefono,
            "fechaNacimiento" to model.fechaNacimiento,
            "ciudad" to model.ciudad,
            "localidad" to model.localidad,
            "direccion" to model.direccion,
            "obraSocial" to model.obraSocial,
            "afiliado" to model.afiliado)
        ).await()
        return true
    }

    suspend fun eliminar(model: PatientModel): Boolean{
        val paciente = FirestoreInstance.get().collection(FirestoreConstante.COLECCION_PACIENTES).document(model.dni)
        paciente.delete().await()
        return true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun grabar(model: PatientModel): Boolean{
        return if(model.dni.isEmpty()){
            registrar(model)
        } else {
            actualizar(model)
        }
    }
}