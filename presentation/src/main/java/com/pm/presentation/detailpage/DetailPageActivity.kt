package com.pm.presentation.detailpage

import android.content.Intent
import coil.load
import com.pm.presentation.R
import com.pm.presentation.base.BaseViewModelActivity
import com.pm.presentation.buyorsaleregistration.BuyOrSaleRegistrationActivity
import com.pm.presentation.databinding.ActivityDetailPageBinding
import com.pm.presentation.detailpage.recyclerview.DetailListAdapter
import com.pm.presentation.detailpage.recyclerview.MatchingListAdapter

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
            btnBack.setOnClickListener {
                onBackPressed()
                finish()
            }

            btnBuy.setOnClickListener {
                val intent =
                    Intent(this@DetailPageActivity, BuyOrSaleRegistrationActivity::class.java)
                intent.putExtra("is_buy_or_sale", "buy")
                intent.putExtra("uniqueKey", viewModel.uniqueKey)
                startActivity(intent)
                overridePendingTransition(0, 0)
            }
            btnSale.setOnClickListener {
                val intent =
                    Intent(this@DetailPageActivity, BuyOrSaleRegistrationActivity::class.java)
                intent.putExtra("is_buy_or_sale", "sale")
                intent.putExtra("uniqueKey", viewModel.uniqueKey)
                startActivity(intent)
                overridePendingTransition(0, 0)
            }
        }
    }

    override fun observeChanges() {
        super.observeChanges()

        viewModel.isStateBuyOrSale.observe(this) {
            viewModel.getBuyOrSaleList(it)
        }

        viewModel.buyOrSaleList.observe(this) {
            detailListAdapter.submitList(it)
        }

        viewModel.matchingList.observe(this) {
            matchingListAdapter.submitList(it)
        }

        viewModel.photoCardInfo.observe(this) {
            binding.ivPhoca.load(it.imageUrl)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, 0)
    }
}