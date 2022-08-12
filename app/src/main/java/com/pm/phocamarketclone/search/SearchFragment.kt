package com.pm.phocamarketclone.search

import android.content.Intent
import android.view.inputmethod.EditorInfo
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BindingViewModelFragment
import com.pm.phocamarketclone.databinding.FragmentSearchBinding
import com.pm.phocamarketclone.detailpage.DetailPageActivity
import com.pm.phocamarketclone.search.data.SearchData
import com.pm.phocamarketclone.search.recyclerview.SearchListAdapter

class SearchFragment : BindingViewModelFragment<FragmentSearchBinding, SearchFragmentViewModel>(
    R.layout.fragment_search,
    SearchFragmentViewModel::class.java
) {
    private val searchListAdapter = SearchListAdapter(SearchListener())

    override fun onInitBinding() {
        super.onInitBinding()
        binding.apply {
            rvSearchList.run {
                adapter = searchListAdapter
                itemAnimator = null
                vm = viewModel
                lifecycleOwner = this@SearchFragment
                fragment = this@SearchFragment

                etSearch.setOnEditorActionListener { v, actionId, event ->
                    if (actionId === EditorInfo.IME_ACTION_SEARCH) {
                        viewModel.search(etSearch.text.toString())
                        return@setOnEditorActionListener true
                    }
                    false
                }

            }
        }
    }

    override fun observerChanges() {
        super.observerChanges()
        viewModel.searchList.observe(this) {
            searchListAdapter.submitList(it)
        }
    }

    fun statusTop() {
        binding.rvSearchList.scrollToPosition(0)
    }

    private inner class SearchListener : SearchListAdapter.SearchListener {
        override fun onClickItem(item: SearchData) {
            val intent = Intent(context, DetailPageActivity::class.java)
            intent.putExtra("uniqueKey", item.uniqueKey)
            startActivity(intent)
            requireActivity().overridePendingTransition(0, 0)
        }

    }
}