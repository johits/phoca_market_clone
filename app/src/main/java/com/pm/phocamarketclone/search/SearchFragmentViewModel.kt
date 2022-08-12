package com.pm.phocamarketclone.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.pm.phocamarketclone.search.data.SearchData


class SearchFragmentViewModel() : ViewModel() {
    private val _searchList = MutableLiveData<List<SearchData>>()
    val searchList: LiveData<List<SearchData>> = _searchList
    val isWish = MutableLiveData(false)
    private val db = FirebaseFirestore.getInstance()
    private val photoCardRef = db.collection("photocardlist")

    init {
        readSearchData()
    }


    fun readSearchData() {
        val list = ArrayList<SearchData>()
        photoCardRef
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    list.add(
                        SearchData(
                            uniqueKey = document.id,
                            imageUrl = document.data["imageUrl"].toString(),
                            title = document.data["cardName"].toString(),
                            recentTransaction = document.data["recentPrice"].toString().toInt(),
                            heart = document.data["heart"].toString().toBoolean()
                        )
                    )
                }
                _searchList.value = list
            }
            .addOnFailureListener { exception ->
            }
    }

    fun search(keyword: String) {
        val list = ArrayList<SearchData>()
        photoCardRef
            .whereEqualTo("member", keyword)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    list.add(
                        SearchData(
                            uniqueKey = document.id,
                            imageUrl = document.data["imageUrl"].toString(),
                            title = document.data["cardName"].toString(),
                            recentTransaction = document.data["recentPrice"].toString().toInt(),
                            heart = document.data["heart"].toString().toBoolean()
                        )
                    )
                }
                _searchList.value = list
            }
            .addOnFailureListener { exception ->
            }

    }
}