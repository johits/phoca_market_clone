package com.pm.phocamarketclone.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.pm.phocamarketclone.data.PhocaApiProvider
import com.pm.phocamarketclone.search.data.SearchData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class SearchFragmentViewModel() : ViewModel() {
    private val _searchList = MutableLiveData<List<SearchData>>()
    val searchList: LiveData<List<SearchData>> = _searchList

    val isWish = MutableLiveData(false)
    private val phocaApi = PhocaApiProvider.create()

    val db = FirebaseFirestore.getInstance()

    init {
//        setResult()
        readSearchData()
    }

//    fun setResult(keyword: String = "") {
//        phocaApi.get(1, search_keyword = keyword)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                _searchList.value = it.items
//            }) {
//            }
//    }

    fun readSearchData(){
        val list = ArrayList<SearchData>()
        db.collection("photocardlist")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("jhs", "데이터결과: $result")
                    Log.w("jhs", "데이터 ${document.data}")
                    list.add(SearchData(
                        idx = document.data.get("idx").toString().toInt(),
                        imageUrl = document.data.get("imageUrl").toString(),
                        title = document.data.get("cardName").toString(),
                        recentTransaction = document.data.get("recentPrice").toString().toInt(),
                        heart = document.data.get("heart").toString().toBoolean()
                        ))
//
                }
                Log.e("jhs", "리스트 :$list")
                _searchList.value = list
            }
            .addOnFailureListener { exception ->
                Log.w("jhs", "Error getting documents.", exception)
            }
    }
}