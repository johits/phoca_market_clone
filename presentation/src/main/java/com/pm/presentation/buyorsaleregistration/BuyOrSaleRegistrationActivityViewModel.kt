package com.pm.presentation.buyorsaleregistration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.pm.data.model.PhotoCardInfoModel
import com.pm.data.source.RemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BuyOrSaleRegistrationActivityViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val remoteDataSource: RemoteDataSource
) : ViewModel() {

    var uniqueKey: String = savedStateHandle.get<String>("uniqueKey") ?: ""
    var isBuyOrSale: String = savedStateHandle.get<String>("is_buy_or_sale") ?: ""
    val currentPrice = MutableLiveData(0L)
    val photoCardInfo = MutableLiveData<PhotoCardInfoModel>()

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
        remoteDataSource.getPhotoCardItemInfoData(uniqueKey) {
            photoCardInfo.value = it
        }
    }
}