package com.pm.presentation.detailpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.pm.data.model.PhotoCardInfoModel
import com.pm.data.repository.RemoteDataRepository
import com.pm.presentation.detailpage.data.DetailData
import com.pm.presentation.detailpage.data.MatchingHistoryData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

enum class DetailState(value: String) {
    BUY("buy"), SALE("sale")
}

@HiltViewModel
class DetailPageActivityViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val remoteDataRepository: RemoteDataRepository
) :
    ViewModel() {

    var uniqueKey: String = savedStateHandle.get<String>("uniqueKey") ?: ""

    var isStateBuyOrSale = MutableLiveData<DetailState>()
    val photoCardInfo = MutableLiveData<PhotoCardInfoModel>()

    private val _buyOrSaleList = MutableLiveData<List<DetailData>>()
    val buyOrSaleList: LiveData<List<DetailData>> = _buyOrSaleList

    private val _matchingList = MutableLiveData<List<MatchingHistoryData>>()
    val matchingList: LiveData<List<MatchingHistoryData>> = _matchingList

    init {
        getPhotoCardInfo()
        getBuyOrSaleList(DetailState.BUY)
        getMatchingList()
        isStateBuyOrSale.value = DetailState.BUY
    }


    private fun getPhotoCardInfo() {
        remoteDataRepository.getPhotoCardItemInfoData(uniqueKey) {
            photoCardInfo.value = it
        }
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

    fun getMatchingList() {
        _matchingList.value = listOf(
            MatchingHistoryData(matchingPrice = 1111L),
            MatchingHistoryData(matchingPrice = 2222L),
            MatchingHistoryData(matchingPrice = 3333L),
            MatchingHistoryData(matchingPrice = 4444L),
            MatchingHistoryData(matchingPrice = 5555L)
        )
    }


    fun setOnClickMatchWaitingState(type: DetailState) {
        when (type) {
            DetailState.BUY -> isStateBuyOrSale.value = DetailState.BUY
            DetailState.SALE -> isStateBuyOrSale.value = DetailState.SALE
        }
    }
}