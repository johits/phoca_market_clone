package com.pm.phocamarketclone.search.data

//검색 결과 리스트
data class SearchData(
    val imageUrl: String = "",
    val title: String,
    val recentTransaction: Int = 0,
    val actualTransaction: Int = 0,
    val heart: Boolean = false
)
