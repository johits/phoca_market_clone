package com.pm.phocamarketclone.detailpage.recyclerview

import android.view.ViewGroup
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BaseViewHolder
import com.pm.phocamarketclone.databinding.RvDetailPageItemBinding
import com.pm.phocamarketclone.detailpage.data.MatchingHistoryData
import java.text.SimpleDateFormat
import java.util.*

class MatchingListViewHolder(parent: ViewGroup) :
    BaseViewHolder<MatchingHistoryData, RvDetailPageItemBinding>(
        R.layout.rv_detail_page_item,
        parent
    ) {
    override fun bind(item: MatchingHistoryData) {
        val dayFormat = SimpleDateFormat("yyyy/MM/dd", Locale.ROOT)
        binding.apply {
            tvDate.text = dayFormat.format(item.matchingDate)
            tvPrice.text = context.getString(R.string.price_unit_format, item.matchingPrice)
        }
    }
}