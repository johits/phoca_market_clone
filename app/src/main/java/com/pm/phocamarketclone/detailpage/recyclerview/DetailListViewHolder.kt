package com.pm.phocamarketclone.detailpage.recyclerview

import android.view.ViewGroup
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BaseViewHolder
import com.pm.phocamarketclone.databinding.RvDetailPageItemBinding
import com.pm.phocamarketclone.detailpage.data.DetailData
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
            tvPrice.text = item.hopePrice.toString()
        }
    }
}