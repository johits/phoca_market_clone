package com.pm.data.source

import com.pm.data.api.FirestoreDao
import com.pm.data.model.PhotoCardInfoModel
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
) : RemoteDataSource {
    override fun getPhotoCardInfoData(callback: (List<PhotoCardInfoModel>) -> Unit) {
        FirestoreDao().photoCardRef
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
        FirestoreDao().photoCardRef
            .whereEqualTo("member", keyword)
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
        FirestoreDao(uniqueKey).photoCardItemRef
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