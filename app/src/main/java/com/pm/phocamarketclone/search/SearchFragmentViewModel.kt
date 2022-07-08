package com.pm.phocamarketclone.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pm.phocamarketclone.search.data.SearchData

class SearchFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val _searchList = MutableLiveData<List<SearchData>>()
    val searchList: LiveData<List<SearchData>> = _searchList

    val isWish = MutableLiveData(false)

    init {
        //TODO: (임시) 테스트 더미데이터 추가 -> 추후에 삭제
        _searchList.value = listOf(
            SearchData("", "enhypen", 3000, 4500, true),
            SearchData("", "enhypen1", 1000, 2000, true),
            SearchData("", "enhypen2", 1500, 4000, false),
            SearchData("", "enhypen3", 2000, 3000, false),
            SearchData("", "enhypen4", 3000, 7000, true)
        )
    }
}