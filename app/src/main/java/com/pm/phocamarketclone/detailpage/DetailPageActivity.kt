package com.pm.phocamarketclone.detailpage

import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BaseViewModelActivity
import com.pm.phocamarketclone.databinding.ActivityDetailPageBinding
import com.pm.phocamarketclone.detailpage.recyclerview.DetailListAdapter
import com.pm.phocamarketclone.detailpage.recyclerview.MatchingListAdapter

class DetailPageActivity :
    BaseViewModelActivity<ActivityDetailPageBinding, DetailPageActivityViewModel>(
        R.layout.activity_detail_page,
        DetailPageActivityViewModel::class.java
    ) {
    private val detailListAdapter = DetailListAdapter()
    private val matchingListAdapter = MatchingListAdapter()

    override fun onInitBinding() {
        super.onInitBinding()
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@DetailPageActivity
            rvBuyOrSaleInfo.run {
                adapter = detailListAdapter
                itemAnimator = null
            }
            rvMatchingHistory.run {
                adapter = matchingListAdapter
                itemAnimator = null

            }
        }
    }

    override fun observeChanges() {
        super.observeChanges()

        viewModel.isStateBuyOrSale.observe(this){
            viewModel.getBuyOrSaleList(it)
        }

        viewModel.buyOrSaleList.observe(this){
            detailListAdapter.submitList(it)
        }

        viewModel.matchingList.observe(this){
            matchingListAdapter.submitList(it)
        }
    }
}