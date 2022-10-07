package com.pm.phocamarketclone.search.recyclerview

import android.view.ViewGroup
import coil.load
import com.example.data.model.PhotoCardInfoModel
import com.example.data.source.ImageSourceImpl
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BaseViewHolder
import com.pm.phocamarketclone.databinding.RvSearchItemBinding


class SearchListViewHolder(parent: ViewGroup) :
    BaseViewHolder<PhotoCardInfoModel, RvSearchItemBinding>(R.layout.rv_search_item, parent) {

    override fun bind(item: PhotoCardInfoModel) {
        binding.apply {
            tvPhocaName.text = item.cardName
            tvRecentPrice.text = String.format("%,d 원", item.recentPrice)
            cbHeart.isChecked = item.heart
            ImageSourceImpl(context).getImageUrl(item.imageUrl) {
                ivPhoca.load(it)
            }
        }
    }
}