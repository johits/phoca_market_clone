package com.pm.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pm.data.model.PhotoCardInfoModel
import com.pm.data.source.RemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SearchFragmentViewModel @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    ViewModel() {
    private val _searchList = MutableLiveData<List<PhotoCardInfoModel>>()
    val searchList: LiveData<List<PhotoCardInfoModel>> = _searchList
    val isWish = MutableLiveData(false)

    init {
        remoteDataSource.getPhotoCardInfoData {
            _searchList.value = it
        }
    }

    fun search(keyword: String) {
        remoteDataSource.searchPhotoCardInfoData(keyword) {
            _searchList.value = it
        }
    }

}