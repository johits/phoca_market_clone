package com.pm.phocamarketclone.search.data

import android.os.Parcelable
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import timber.log.Timber

//검색 결과 리스트

@Parcelize
data class ResultGetSearch(
    var result: Boolean = false,
    @SerializedName("data")
    var items: List<SearchData>
) : Parcelable


@Parcelize
data class SearchData(
    val uniqueKey: String = "",
    val imageUrl: String = "",
    @SerializedName("cardName")
    val title: String,
    val recentTransaction: Int = 0,
    val actualTransaction: Int = 0,
    val heart: Boolean = false
) : Parcelable {
    private val storage by lazy {
        Firebase.storage
    }
    val url
        get() =
            storage.reference.child(
                "/searchPhotoCard/$imageUrl"
            ).downloadUrl
                .addOnSuccessListener { uri ->
                    Timber.e("jhs 이미지 유알엘:$imageUrl")
                    uri.toString()
                }.addOnFailureListener {
                }
}
