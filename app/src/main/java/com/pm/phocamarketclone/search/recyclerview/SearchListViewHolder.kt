package com.pm.phocamarketclone.search.recyclerview

import android.view.ViewGroup
import coil.load
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BaseViewHolder
import com.pm.phocamarketclone.databinding.RvSearchItemBinding
import com.pm.phocamarketclone.search.data.SearchData
import timber.log.Timber


class SearchListViewHolder(parent: ViewGroup) :
    BaseViewHolder<SearchData, RvSearchItemBinding>(
        R.layout.rv_search_item,
        parent
    ) {

//    private val storage by lazy {
//        Firebase.storage
//    }

    override fun bind(item: SearchData) {
        binding.apply {
            tvPhocaName.text = item.title
            tvRecentPrice.text = String.format("%,d 원", item.recentTransaction)
            cbHeart.isChecked = item.heart
//            ivPhoca.load(uri.toString())
            Timber.w("jhs 유알엘은? :${item.url.toString()}")
            ivPhoca.load(item.url.toString())

//            storage.reference.child(
//                context.getString(
//                    R.string.image_base_url,
//                    item.imageUrl
//                )
//            ).downloadUrl
//                .addOnSuccessListener { uri ->
//                    ivPhoca.load(uri.toString())
//                }.addOnFailureListener {
//                }
        }
    }
}