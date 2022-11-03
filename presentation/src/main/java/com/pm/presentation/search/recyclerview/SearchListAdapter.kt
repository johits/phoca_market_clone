package com.pm.presentation.search.recyclerview

import android.view.ViewGroup
import com.pm.data.model.PhotoCardInfoModel
import com.pm.presentation.base.BaseListAdapter
import com.pm.presentation.databinding.RvSearchItemBinding

class SearchListAdapter(private val listener: SearchListener) :
    BaseListAdapter<PhotoCardInfoModel, RvSearchItemBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchListViewHolder(parent)
            .apply(::setOnEventHolder)

    private fun setOnEventHolder(holder: SearchListViewHolder) {
        holder.apply {
            binding.apply {
                root.setOnClickListener { listener.onClickItem(getItem(bindingAdapterPosition)) }
                cbHeart.setOnClickListener { listener.onClickHeart(getItem(bindingAdapterPosition),cbHeart.isChecked) }
            }
        }
    }

    interface SearchListener {
        fun onClickItem(item: PhotoCardInfoModel)
        fun onClickHeart(item: PhotoCardInfoModel, isChecked:Boolean)
    }
}