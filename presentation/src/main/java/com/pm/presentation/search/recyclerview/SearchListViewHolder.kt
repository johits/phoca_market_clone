package com.pm.presentation.search.recyclerview

import android.view.ViewGroup
import coil.load
import com.pm.data.model.PhotoCardInfoModel
import com.pm.presentation.R
import com.pm.presentation.base.BaseViewHolder
import com.pm.presentation.databinding.RvSearchItemBinding


class SearchListViewHolder(parent: ViewGroup) :
    BaseViewHolder<PhotoCardInfoModel, RvSearchItemBinding>(R.layout.rv_search_item, parent) {

    override fun bind(item: PhotoCardInfoModel) {
        binding.apply {
            tvPhocaName.text = item.cardName
            tvRecentPrice.text = String.format("%,d 원", item.recentPrice)
            cbHeart.isChecked = item.heart
            ivPhoca.load(item.imageUrl)
        }
    }
}