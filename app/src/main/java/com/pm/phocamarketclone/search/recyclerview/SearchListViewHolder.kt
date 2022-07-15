package com.pm.phocamarketclone.search.recyclerview

import android.view.ViewGroup
import coil.load
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BaseViewHolder
import com.pm.phocamarketclone.databinding.RvSearchItemBinding
import com.pm.phocamarketclone.search.data.SearchData

class SearchListViewHolder(parent: ViewGroup) :
    BaseViewHolder<SearchData, RvSearchItemBinding>(R.layout.rv_search_item, parent) {
    override fun bind(item: SearchData) {
        binding.apply {
            ivPhoca.load(item.imageUrl)
            tvPhocaName.text = item.title
            tvRecentPrice.text = String.format("%,d 원", item.recentTransaction)
            tvActualPrice.text = String.format("%,d 원", item.actualTransaction)
            cbHeart.isChecked = item.heart
        }
    }
}