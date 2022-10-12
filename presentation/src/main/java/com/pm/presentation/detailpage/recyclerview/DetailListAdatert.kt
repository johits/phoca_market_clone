package com.pm.presentation.detailpage.recyclerview

import android.view.ViewGroup
import com.pm.presentation.base.BaseListAdapter
import com.pm.presentation.databinding.RvDetailPageItemBinding
import com.pm.presentation.detailpage.data.DetailData

class DetailListAdapter() :
    BaseListAdapter<DetailData, RvDetailPageItemBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DetailListViewHolder(parent)

}