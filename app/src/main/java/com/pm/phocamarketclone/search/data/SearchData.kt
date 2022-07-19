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
    @SerializedName("path")
    val imageUrl: String = "",
    @SerializedName("cardName")
    val title: String,
    val recentTransaction: Int = 0,
    val actualTransaction: Int = 0,
    val heart: Boolean = false
) : Parcelable
