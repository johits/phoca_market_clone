package com.pm.presentation.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T, B : ViewDataBinding>(
    @LayoutRes layoutRes: Int,
    parent: ViewGroup
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)) {
    val binding: B = DataBindingUtil.bind(itemView)!!
    protected val context: Context get() = binding.root.context

    open fun bind(item: T) {}
}