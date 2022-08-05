package com.pm.phocamarketclone.detailpage.recyclerview

import android.view.ViewGroup
import com.pm.phocamarketclone.base.BaseListAdapter
import com.pm.phocamarketclone.databinding.RvDetailPageItemBinding
import com.pm.phocamarketclone.detailpage.data.DetailData

class DetailListAdapter() :
    BaseListAdapter<DetailData, RvDetailPageItemBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DetailListViewHolder(parent)

}