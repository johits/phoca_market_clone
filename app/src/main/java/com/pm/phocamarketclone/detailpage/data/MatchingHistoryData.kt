package com.pm.phocamarketclone.detailpage.data

import java.util.*

//매칭 히스토리 데이터
data class MatchingHistoryData(
    val matchingDate: Date = Date(),
    val matchingPrice: Long = 0L
)
