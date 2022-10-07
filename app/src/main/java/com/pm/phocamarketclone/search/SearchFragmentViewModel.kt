package com.pm.phocamarketclone.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.model.PhotoCardInfoModel
import com.example.data.source.RemoteDataSourceImpl
import timber.log.Timber


class SearchFragmentViewModel() : ViewModel() {
    private val _searchList = MutableLiveData<List<PhotoCardInfoModel>>()
    val searchList: LiveData<List<PhotoCardInfoModel>> = _searchList
    val isWish = MutableLiveData(false)
    private val remoteDataSourceImpl = RemoteDataSourceImpl()

    init {
        remoteDataSourceImpl.getPhotoCardInfoData {
            _searchList.value = it
        }
    }

    fun search(keyword: String) {
        remoteDataSourceImpl.searchPhotoCardInfoData(keyword) {
            _searchList.value = it
        }
    }

}