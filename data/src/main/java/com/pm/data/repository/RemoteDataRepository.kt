package com.pm.data.repository

import com.pm.data.model.PhotoCardInfoModel

interface RemoteDataRepository {
    fun getPhotoCardInfoData(callback: (List<PhotoCardInfoModel>) -> Unit)
    fun searchPhotoCardInfoData(keyword: String, callback: (List<PhotoCardInfoModel>) -> Unit)
    fun getPhotoCardItemInfoData(uniqueKey: String, callback: (PhotoCardInfoModel) -> Unit)
}