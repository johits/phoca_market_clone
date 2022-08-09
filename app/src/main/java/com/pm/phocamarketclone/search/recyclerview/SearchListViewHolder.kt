package com.pm.phocamarketclone.search.recyclerview

import android.view.ViewGroup
import coil.load
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BaseViewHolder
import com.pm.phocamarketclone.databinding.RvSearchItemBinding
import com.pm.phocamarketclone.search.data.SearchData


class SearchListViewHolder(parent: ViewGroup) :
    BaseViewHolder<SearchData, RvSearchItemBinding>(
        com.pm.phocamarketclone.R.layout.rv_search_item,
        parent
    ) {

    private val storage by lazy {
        Firebase.storage
    }

    override fun bind(item: SearchData) {
        binding.apply {
//            ivPhoca.load(context.getString(com.pm.phocamarketclone.R.string.image_base_url, item.imageUrl))
            tvPhocaName.text = item.title
            tvRecentPrice.text = String.format("%,d 원", item.recentTransaction)
            tvActualPrice.text = String.format("%,d 원", item.actualTransaction)
            cbHeart.isChecked = item.heart

            storage.reference.child(
                context.getString(
                    R.string.image_base_url,
                    item.imageUrl
                )
            ).downloadUrl
                .addOnSuccessListener { uri ->
                    ivPhoca.load(uri.toString())
                }.addOnFailureListener {
                }

//            val a = FirebaseStorage.getInstance().reference.child("/searchPhotoCard/new.jfif")
////            ivPhoca.load(context.getString(com.pm.phocamarketclone.R.string.image_base_url, a))
//            val file = File.createTempFile("new", "jpg")
//            a.getFile(file).addOnSuccessListener {
//                val bitmap = BitmapFactory.decodeFile(file.absolutePath)
//                ivPhoca.setImageBitmap(bitmap)
//            }.addOnFailureListener { }
        }
    }
}