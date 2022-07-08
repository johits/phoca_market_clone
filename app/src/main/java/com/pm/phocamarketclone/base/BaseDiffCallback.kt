package com.pm.phocamarketclone.base

import androidx.recyclerview.widget.DiffUtil

object BaseDiffCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        if (oldItem is DiffModel && newItem is DiffModel) {
            return oldItem.diffId == newItem.diffId
        }
        return false
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        if (oldItem is DiffModel && newItem is DiffModel) {
            return oldItem == newItem
        }
        return false
    }
}
