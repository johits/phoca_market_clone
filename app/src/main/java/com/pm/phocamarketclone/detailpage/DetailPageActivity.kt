package com.pm.phocamarketclone.detailpage

import android.content.Intent
import android.util.Log
import coil.load
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BaseViewModelActivity
import com.pm.phocamarketclone.buyorsaleregistration.BuyOrSaleRegistrationActivity
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
    private val storage by lazy {
        Firebase.storage
    }
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
            btnBack.setOnClickListener{
                onBackPressed()
                finish()}

            btnBuy.setOnClickListener {
                val intent = Intent(this@DetailPageActivity, BuyOrSaleRegistrationActivity::class.java)
                intent.putExtra("is_buy_or_sale", "buy")
                startActivity(intent)
                overridePendingTransition(0, 0)
            }
            btnSale.setOnClickListener {
                val intent = Intent(this@DetailPageActivity, BuyOrSaleRegistrationActivity::class.java)
                intent.putExtra("is_buy_or_sale", "sale")
                startActivity(intent)
                overridePendingTransition(0, 0)
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

        viewModel.photoCardInfo.observe(this){
            storage.reference.child(
                this@DetailPageActivity.getString(
                    R.string.image_base_url,
                    viewModel.photoCardInfo.value?.imageUrl
                )
            ).downloadUrl
                .addOnSuccessListener { uri ->
                    Log.d("jhs", "onInitBinding: $uri")
                    binding.ivPhoca.load(uri.toString())
                }.addOnFailureListener {
                }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, 0)
    }
}