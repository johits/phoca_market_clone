package com.pm.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.pm.data.model.PhotoCardInfoModel
import com.pm.data.util.FireStoreCollection
import com.pm.data.util.FireStoreDocumentField
import javax.inject.Inject

class RemoteDataRepositoryImpl @Inject constructor(
    private val database: FirebaseFirestore
) : RemoteDataRepository {
    override fun getPhotoCardInfoData(callback: (List<PhotoCardInfoModel>) -> Unit) {
        database.collection(FireStoreCollection.PHOTOCARD_LIST)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val list = task.result.toObjects(PhotoCardInfoModel::class.java)
                    callback.invoke(list)
                }
            }
    }

    override fun searchPhotoCardInfoData(
        keyword: String,
        callback: (List<PhotoCardInfoModel>) -> Unit
    ) {
        database.collection(FireStoreCollection.PHOTOCARD_LIST)
            .whereEqualTo(FireStoreDocumentField.MEMBER, keyword)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val list = task.result.toObjects(PhotoCardInfoModel::class.java)
                    callback.invoke(list)
                }
            }
    }

    override fun getPhotoCardItemInfoData(
        uniqueKey: String,
        callback: (PhotoCardInfoModel) -> Unit
    ) {
        database.collection(FireStoreCollection.PHOTOCARD_LIST).document(uniqueKey)
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val item = PhotoCardInfoModel(
                        id = document.id,
                        cardName = document.data!!["cardName"].toString(),
                        imageUrl = document.data!!["imageUrl"].toString(),
                        group = document.data!!["group"].toString(),
                        member = document.data!!["member"].toString(),
                        recentPrice = document.data!!["recentPrice"].toString().toInt(),
                        heart = document.data!!["heart"].toString().toBoolean()
                    )
                    callback.invoke(item)
                }
            }
    }
}