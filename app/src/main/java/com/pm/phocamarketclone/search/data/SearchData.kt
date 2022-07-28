package com.pm.phocamarketclone.search.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//검색 결과 리스트

@Parcelize
data class ResultGetSearch(
    @SerializedName("result")
    var result: Boolean = false,
    @SerializedName("data")
    var items: List<SearchData>
) : Parcelable


@Parcelize
data class SearchData(
    @SerializedName("imageUrl")
    val idx: String ="",
    @SerializedName("imageUrl")
    val imageUrl: String = "",
    @SerializedName("cardName")
    val title: String,
    @SerializedName("recentPrice")
    val recentTransaction: Int = 0,
    @SerializedName("heart")
    val heart: Boolean = false
) : Parcelable
