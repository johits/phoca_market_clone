package com.example.data.source

interface ImageSource {
    fun getImageUrl(url: String, callback: (String) -> Unit)
}