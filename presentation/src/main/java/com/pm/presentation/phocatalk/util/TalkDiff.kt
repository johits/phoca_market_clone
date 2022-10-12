package com.pm.presentation.phocatalk.util

import androidx.recyclerview.widget.DiffUtil
import com.pm.presentation.phocatalk.model.TalkVO

class TalkDiff : DiffUtil.ItemCallback<TalkVO>() {
    override fun areItemsTheSame(oldItem: TalkVO, newItem: TalkVO): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TalkVO, newItem: TalkVO): Boolean {
        return oldItem.time == newItem.time
    }
}