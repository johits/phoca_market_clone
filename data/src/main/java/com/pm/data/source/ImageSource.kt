package com.pm.data.source

interface ImageSource {
    fun getImageUrl(url: String, callback: (String) -> Unit)
}