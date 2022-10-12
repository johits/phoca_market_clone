package com.pm.presentation.buyorsaleregistration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.pm.data.model.PhotoCardInfoModel
import com.pm.data.source.RemoteDataSourceImpl

class BuyOrSaleRegistrationActivityViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var uniqueKey: String = savedStateHandle.get<String>("uniqueKey") ?: ""
    var isBuyOrSale: String = savedStateHandle.get<String>("is_buy_or_sale") ?: ""
    val currentPrice = MutableLiveData(0L)
    val photoCardInfo = MutableLiveData<PhotoCardInfoModel>()
    private val remoteDataSourceImpl = RemoteDataSourceImpl()

    init {
        getPhotoCardInfo()
    }

    fun setCurrentPrice(price: Long) {
        currentPrice.value = price
    }

    fun setAddAmount(plusPrice: Long) {
        currentPrice.value = (currentPrice.value.toString().toLong()) + plusPrice
    }

    private fun getPhotoCardInfo() {
        remoteDataSourceImpl.getPhotoCardItemInfoData(uniqueKey) {
            photoCardInfo.value = it
        }
    }
}