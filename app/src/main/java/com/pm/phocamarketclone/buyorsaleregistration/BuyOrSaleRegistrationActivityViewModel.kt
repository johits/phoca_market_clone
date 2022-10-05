package com.pm.phocamarketclone.buyorsaleregistration

import android.util.Log
import androidx.core.util.LogWriter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.pm.phocamarketclone.detailpage.data.PhotoCardInfo
import timber.log.Timber

class BuyOrSaleRegistrationActivityViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    var uniqueKey: String = savedStateHandle.get<String>("uniqueKey") ?: ""
    var isBuyOrSale: String = savedStateHandle.get<String>("is_buy_or_sale") ?: ""
    val currentPrice = MutableLiveData(0L)
    val photoCardInfo = MutableLiveData<PhotoCardInfo>()
    private val db = FirebaseFirestore.getInstance()

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
        Timber.w("jhs 포카 정보 유니크키:$uniqueKey")
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
        Timber.d("jhs 포카 정보:${photoCardInfo.value }")
    }
}