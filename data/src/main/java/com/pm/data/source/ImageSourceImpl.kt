package com.pm.data.source

import android.content.Context
import com.pm.data.R
import com.google.firebase.storage.FirebaseStorage
import javax.inject.Inject

class ImageSourceImpl @Inject constructor(
    private val context: Context
) : ImageSource {
    override fun getImageUrl(url: String, callback: (String) -> Unit) {
        FirebaseStorage.getInstance().reference.child(
            context.getString(
                R.string.image_base_url,
                url
            )
        ).downloadUrl
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback.invoke(task.result.toString())
                }
            }
    }
}