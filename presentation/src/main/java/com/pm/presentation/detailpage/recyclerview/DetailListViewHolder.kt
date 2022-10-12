package com.pm.presentation.detailpage.recyclerview

import android.view.ViewGroup
import com.pm.presentation.base.BaseViewHolder
import com.pm.presentation.R
import com.pm.presentation.databinding.RvDetailPageItemBinding
import com.pm.presentation.detailpage.data.DetailData
import java.text.SimpleDateFormat
import java.util.*

class DetailListViewHolder(parent: ViewGroup) :
    BaseViewHolder<DetailData, RvDetailPageItemBinding>(
        R.layout.rv_detail_page_item,
        parent
    ) {
    override fun bind(item: DetailData) {
        val dayFormat = SimpleDateFormat("yyyy/MM/dd", Locale.ROOT)
        binding.apply {
            tvDate.text = dayFormat.format(item.registrationDate)
            tvPrice.text = context.getString(R.string.price_unit_format, item.hopePrice)
        }
    }
}