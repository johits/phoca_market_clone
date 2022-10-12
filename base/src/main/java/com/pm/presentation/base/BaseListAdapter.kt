package com.pm.presentation.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter


@Suppress("UNCHECKED_CAST")
abstract class BaseListAdapter<T : Any, B : ViewDataBinding>(
    diffCallback: DiffUtil.ItemCallback<T> = BaseDiffCallback as DiffUtil.ItemCallback<T>,
) : ListAdapter<T, BaseViewHolder<T, B>>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, B> {
        return BaseViewHolder(viewType, parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
        holder.bind(getItem(position))
    }
}