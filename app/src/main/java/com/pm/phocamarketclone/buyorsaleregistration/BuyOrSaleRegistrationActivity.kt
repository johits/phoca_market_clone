package com.pm.phocamarketclone.buyorsaleregistration

import android.util.Log
import android.view.View
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BaseViewModelActivity
import com.pm.phocamarketclone.databinding.ActivityBuyOrSaleRegistrationBinding

class BuyOrSaleRegistrationActivity :
    BaseViewModelActivity<ActivityBuyOrSaleRegistrationBinding, BuyOrSaleRegistrationActivityViewModel>(
        R.layout.activity_buy_or_sale_registration,
        BuyOrSaleRegistrationActivityViewModel::class.java
    ), View.OnClickListener {

    override fun onInitBinding() {
        super.onInitBinding()
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@BuyOrSaleRegistrationActivity
            btnBack.setOnClickListener(this@BuyOrSaleRegistrationActivity)
            btn10000.setOnClickListener(this@BuyOrSaleRegistrationActivity)
            btn5000.setOnClickListener(this@BuyOrSaleRegistrationActivity)
            btn1000.setOnClickListener(this@BuyOrSaleRegistrationActivity)
            btn500.setOnClickListener(this@BuyOrSaleRegistrationActivity)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, 0)
    }

    override fun onClick(v: View) {
        binding.apply {
            val currentPrice = etPrice.text.toString().toLong()
            Log.d("jhs", "현재금액 $currentPrice")
            when (v) {
                btnBack -> {
                    onBackPressed()
                    finish()
                }
                btn10000 -> viewModel.setCurrentPrice(10000L)
                btn5000 -> viewModel.setCurrentPrice(5000L)
                btn1000 -> viewModel.setCurrentPrice(1000L)
                btn500 -> viewModel.setCurrentPrice(500L)
            }
        }
    }
}