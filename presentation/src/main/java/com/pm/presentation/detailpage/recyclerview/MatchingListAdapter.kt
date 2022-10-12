package com.pm.presentation.detailpage.recyclerview

import android.view.ViewGroup
import com.pm.presentation.base.BaseListAdapter
import com.pm.presentation.databinding.RvDetailPageItemBinding
import com.pm.presentation.detailpage.data.MatchingHistoryData

class MatchingListAdapter() :
    BaseListAdapter<MatchingHistoryData, RvDetailPageItemBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MatchingListViewHolder(parent)

}