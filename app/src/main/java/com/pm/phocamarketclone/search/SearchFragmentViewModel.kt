package com.pm.phocamarketclone.search

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pm.phocamarketclone.data.PhocaApiProvider
import com.pm.phocamarketclone.search.data.SearchData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val _searchList = MutableLiveData<List<SearchData>>()
    val searchList: LiveData<List<SearchData>> = _searchList

    val isWish = MutableLiveData(false)
    private val phocaApi = PhocaApiProvider.create()
    init {
        setResult()
    }

    fun setResult(){
        phocaApi.get("1")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _searchList.value = it.items
            }) {
            }
            }
}