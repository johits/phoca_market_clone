package com.example.data.repository

import com.example.data.model.PhotoCardInfoModel
import com.example.data.source.RemoteDataSource
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class PhotoCardInfoRepositoryImpl @Inject constructor() :
    RemoteDataSource {
    private val db = FirebaseFirestore.getInstance()
    private val photoCardRef = db.collection("photocardlist")
    override fun getPhotoCardData(): List<com.example.data.model.PhotoCardInfoModel> {
        val list = ArrayList<com.example.data.model.PhotoCardInfoModel>()
        photoCardRef
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    list.add(
                        com.example.data.model.PhotoCardInfoModel(
                            uniqueKey = document.id,
                            imageUrl = document.data["imageUrl"].toString(),
                            title = document.data["cardName"].toString(),
                            recentTransaction = document.data["recentPrice"].toString().toInt(),
                            heart = document.data["heart"].toString().toBoolean()
                        )
                    )
                }
            }
            .addOnFailureListener {}
        return list
    }

}