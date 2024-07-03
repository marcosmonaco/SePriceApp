package com.sepriceapp.data.comunes

import com.google.firebase.firestore.FirebaseFirestore

object FirestoreInstance {

    fun get(): FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }
}