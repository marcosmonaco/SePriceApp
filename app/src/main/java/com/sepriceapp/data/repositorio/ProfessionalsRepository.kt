package com.sepriceapp.data.repositorio

import com.sepriceapp.data.comunes.FirestoreConstante
import com.sepriceapp.data.comunes.FirestoreInstance
import com.sepriceapp.data.model.ProfessionalModel
import kotlinx.coroutines.tasks.await

class ProfessionalsRepository {

    suspend fun listar(dato: String): List<ProfessionalModel> {
        return FirestoreInstance.get().collection(FirestoreConstante.COLECCION_PROFESIONALES)
            .orderBy("id").startAt(dato).endAt(dato + "\uf8ff")
            .get().await().toObjects(ProfessionalModel::class.java)
    }

    private suspend fun registrar(model: ProfessionalModel): Boolean {
        val profesionales = FirestoreInstance.get().collection(FirestoreConstante.COLECCION_PROFESIONALES).document()
        model.id = profesionales.id
        profesionales.set(model).await()
        return true
    }

    private suspend fun actualizar(model: ProfessionalModel): Boolean{
        val profesional = FirestoreInstance.get().collection(FirestoreConstante.COLECCION_PROFESIONALES).document(model.id)
        profesional.update(
            mapOf("nombre" to model.nombre,
            "apellido" to model.apellido,
           "especialidad" to model.especialidad,
            "mail" to model.email)
        ).await()
        return true
    }

    suspend fun eliminar(model: ProfessionalModel): Boolean{
        val profesional = FirestoreInstance.get().collection(FirestoreConstante.COLECCION_PROFESIONALES).document(model.id)
        profesional.delete().await()
        return true
    }

    suspend fun grabar(model: ProfessionalModel): Boolean{
        return if(model.id.isEmpty()){
            registrar(model)
        } else {
            actualizar(model)
        }
    }
}