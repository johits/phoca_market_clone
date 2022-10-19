package com.pm.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pm.data.model.PhotoCardInfoModel
import com.pm.data.repository.RemoteDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SearchFragmentViewModel @Inject constructor(private val remoteDataRepository: RemoteDataRepository) :
    ViewModel() {
    private val _searchList = MutableLiveData<List<PhotoCardInfoModel>>()
    val searchList: LiveData<List<PhotoCardInfoModel>> = _searchList
    val isWish = MutableLiveData(false)

    init {
        remoteDataRepository.getPhotoCardInfoData {
            _searchList.value = it
        }
    }

    fun search(keyword: String) {
        remoteDataRepository.searchPhotoCardInfoData(keyword) {
            _searchList.value = it
        }
    }

}