package com.pm.phocamarketclone.detailpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pm.phocamarketclone.detailpage.data.DetailData

enum class DetailState {
    BUY, SALE
}

class DetailPageActivityViewModel : ViewModel() {
    private val _buyOrSaleList = MutableLiveData<List<DetailData>>()
    val buyOrSaleList: LiveData<List<DetailData>> = _buyOrSaleList
    var isStateBuyOrSale = MutableLiveData<DetailState>()

    init {
        getBuyOrSaleList(DetailState.BUY)
        isStateBuyOrSale.value = DetailState.BUY
    }

    fun getBuyOrSaleList(type: DetailState) {
        val buyData = listOf(
            DetailData(hopePrice = 3000L),
            DetailData(hopePrice = 2000L),
            DetailData(hopePrice = 1000L),
            DetailData(hopePrice = 3500L),
            DetailData(hopePrice = 7000L)
        )
        val saleData = listOf(
            DetailData(hopePrice = 1000L),
            DetailData(hopePrice = 2000L),
            DetailData(hopePrice = 3000L),
            DetailData(hopePrice = 4500L),
            DetailData(hopePrice = 5000L)
        )
        _buyOrSaleList.value = when (type) {
            DetailState.BUY -> buyData
            DetailState.SALE -> saleData
        }
    }

    fun setOnClickMatchWaitingState(type: DetailState) {
        when (type) {
            DetailState.BUY -> isStateBuyOrSale.value = DetailState.BUY
            DetailState.SALE -> isStateBuyOrSale.value = DetailState.SALE
        }
    }
}