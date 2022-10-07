package com.example.data.model

import android.os.Parcelable
import com.google.firebase.firestore.DocumentId
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoCardInfoModel(
    @DocumentId
    val id: String = "",
    val imageUrl: String = "",
    val cardName: String = "",
    val group: String = "",
    val member: String = "",
    val recentPrice: Int = 0,
    val heart: Boolean = false
) : Parcelable
