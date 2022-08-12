package com.pm.phocamarketclone.buyorsaleregistration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BuyOrSaleRegistrationActivityViewModel : ViewModel() {
    val currentPrice = MutableLiveData(0L)

    fun setCurrentPrice(plusPrice: Long) {
        currentPrice.value = (currentPrice.value.toString().toLong()) + plusPrice
    }
}