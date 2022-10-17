package com.pm.presentation.detailpage.data

import java.util.*


//상세 페이지 구매중,판매중
data class DetailData(
    val registrationDate: Date = Date(),
    val hopePrice: Long = 0L
)