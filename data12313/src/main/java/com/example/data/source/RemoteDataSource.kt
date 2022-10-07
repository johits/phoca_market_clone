package com.example.data.source

import com.example.data.model.PhotoCardInfoModel

interface RemoteDataSource {
    fun getPhotoCardData(): List<com.example.data.model.PhotoCardInfoModel>
}