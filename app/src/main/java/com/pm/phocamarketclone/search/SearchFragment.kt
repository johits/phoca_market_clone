package com.pm.phocamarketclone.search

import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BindingViewModelFragment
import com.pm.phocamarketclone.databinding.FragmentSearchBinding
import com.pm.phocamarketclone.search.recyclerview.SearchListAdapter

class SearchFragment : BindingViewModelFragment<FragmentSearchBinding, SearchFragmentViewModel>(
    R.layout.fragment_search,
    SearchFragmentViewModel::class.java
) {
    private val searchListAdapter = SearchListAdapter()

    override fun onInitBinding() {
        super.onInitBinding()
        binding.apply {
            rvSearchList.run {
                adapter = searchListAdapter
                itemAnimator = null
            }
        }
    }

    override fun observerChanges() {
        super.observerChanges()
        viewModel.searchList.observe(this) {
            searchListAdapter.submitList(it)
        }
    }
}