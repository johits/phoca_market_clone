package com.example.data.source

import com.example.data.model.PhotoCardInfoModel

interface RemoteDataSource {
    fun getPhotoCardInfoData(callback: (List<PhotoCardInfoModel>) -> Unit)
    fun searchPhotoCardInfoData(keyword: String, callback: (List<PhotoCardInfoModel>) -> Unit)
    fun getPhotoCardItemInfoData(uniqueKey: String, callback: (PhotoCardInfoModel) -> Unit)
}