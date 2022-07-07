package com.pm.phocamarketclone.phocatalk

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pm.phocamarketclone.phocatalk.model.TalkVO

object TalkBinding {

    @BindingAdapter("list")
    @JvmStatic
    fun bindChatItems(recyclerView: RecyclerView, items: List<TalkVO>?) {
        recyclerView.adapter = TalkAdapter()
        val adapter = recyclerView.adapter as TalkAdapter
        adapter.submitList(items)

    }

}