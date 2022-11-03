package com.pm.presentation.search

import android.content.Intent
import android.view.inputmethod.EditorInfo
import com.pm.data.model.PhotoCardInfoModel
import com.pm.presentation.R
import com.pm.presentation.base.BindingViewModelFragment
import com.pm.presentation.databinding.FragmentSearchBinding
import com.pm.presentation.detailpage.DetailPageActivity
import com.pm.presentation.search.recyclerview.SearchListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BindingViewModelFragment<FragmentSearchBinding, SearchFragmentViewModel>(
    R.layout.fragment_search,
    SearchFragmentViewModel::class.java
) {
    private val searchListAdapter =
        SearchListAdapter(SearchListener())

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
        override fun onClickItem(item: PhotoCardInfoModel) {
            val intent = Intent(context, DetailPageActivity::class.java)
            intent.putExtra("uniqueKey", item.id)
            startActivity(intent)
            requireActivity().overridePendingTransition(0, 0)
        }

        override fun onClickHeart(item: PhotoCardInfoModel, isChecked: Boolean) {
            viewModel.addHeartList(item.id , isChecked)
        }

    }
}