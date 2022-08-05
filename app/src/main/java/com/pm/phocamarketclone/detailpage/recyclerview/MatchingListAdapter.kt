package com.pm.phocamarketclone.detailpage.recyclerview

import android.view.ViewGroup
import com.pm.phocamarketclone.base.BaseListAdapter
import com.pm.phocamarketclone.databinding.RvDetailPageItemBinding
import com.pm.phocamarketclone.detailpage.data.MatchingHistoryData

class MatchingListAdapter() :
    BaseListAdapter<MatchingHistoryData, RvDetailPageItemBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MatchingListViewHolder(parent)

}