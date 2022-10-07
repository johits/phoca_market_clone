package com.example.data.api

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


open class FirestoreDao(
    val uniqueKey:String = ""
) {
    val photoCardRef: CollectionReference by lazy { db.collection("photocardlist") }
    val photoCardItemRef: DocumentReference by lazy { db.collection("photocardlist").document(uniqueKey) }
    protected val db: FirebaseFirestore by lazy { Firebase.firestore }
}