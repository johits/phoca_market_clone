package com.pm.presentation.detailpage.recyclerview

import android.view.ViewGroup
import com.pm.presentation.base.BaseViewHolder
import com.pm.presentation.R
import com.pm.presentation.databinding.RvDetailPageItemBinding
import com.pm.presentation.detailpage.data.MatchingHistoryData
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