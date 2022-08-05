package com.pm.phocamarketclone.search.recyclerview

import android.view.ViewGroup
import com.pm.phocamarketclone.base.BaseListAdapter
import com.pm.phocamarketclone.databinding.RvSearchItemBinding
import com.pm.phocamarketclone.search.data.SearchData

class SearchListAdapter(private val listener:SearchListener) : BaseListAdapter<SearchData, RvSearchItemBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchListViewHolder(parent)
            .apply(::setOnEventHolder)

    private fun setOnEventHolder(holder: SearchListViewHolder){
        holder.apply{
            binding.apply {
                root.setOnClickListener { listener.onClickItem(getItem(bindingAdapterPosition)) }
            }
        }
    }
    interface SearchListener{
        fun onClickItem(item:SearchData)
    }
}