package com.pm.phocamarketclone.detailpage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.pm.phocamarketclone.detailpage.data.DetailData
import com.pm.phocamarketclone.detailpage.data.MatchingHistoryData
import com.pm.phocamarketclone.detailpage.data.PhotoCardInfo

enum class DetailState(value:String) {
    BUY("buy"), SALE("sale")
}

class DetailPageActivityViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var uniqueKey: String = savedStateHandle.get<String>("uniqueKey") ?: ""

    var isStateBuyOrSale = MutableLiveData<DetailState>()
    val photoCardInfo = MutableLiveData<PhotoCardInfo>()

    private val _buyOrSaleList = MutableLiveData<List<DetailData>>()
    val buyOrSaleList: LiveData<List<DetailData>> = _buyOrSaleList

    private val _matchingList = MutableLiveData<List<MatchingHistoryData>>()
    val matchingList: LiveData<List<MatchingHistoryData>> = _matchingList
    private val db = FirebaseFirestore.getInstance()

    init {
        getPhotoCardInfo()
        getBuyOrSaleList(DetailState.BUY)
        getMatchingList()
        isStateBuyOrSale.value = DetailState.BUY
    }


    private fun getPhotoCardInfo() {
        val docRef = db.collection("photocardlist").document(uniqueKey)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    photoCardInfo.value = PhotoCardInfo(
                        cardName = document.data!!["cardName"].toString(),
                        imageUrl = document.data!!["imageUrl"].toString(),
                        group = document.data!!["group"].toString(),
                        member = document.data!!["member"].toString(),
                        recentPrice = document.data!!["recentPrice"].toString().toLong()
                    )

                } else {
                }
            }
            .addOnFailureListener { exception ->
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