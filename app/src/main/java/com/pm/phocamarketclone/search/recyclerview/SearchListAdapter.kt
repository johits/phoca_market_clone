package com.pm.phocamarketclone.search.recyclerview

import android.view.ViewGroup
import com.pm.phocamarketclone.base.BaseListAdapter
import com.pm.phocamarketclone.databinding.RvSearchItemBinding
import com.pm.phocamarketclone.search.data.SearchData

class SearchListAdapter : BaseListAdapter<SearchData, RvSearchItemBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchListViewHolder(parent)
}