package com.pm.phocamarketclone.buyorsaleregistration

import android.view.View
import androidx.core.widget.doOnTextChanged
import coil.load
import com.example.data.source.ImageSourceImpl
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BaseViewModelActivity
import com.pm.phocamarketclone.databinding.ActivityBuyOrSaleRegistrationBinding

class BuyOrSaleRegistrationActivity :
    BaseViewModelActivity<ActivityBuyOrSaleRegistrationBinding, BuyOrSaleRegistrationActivityViewModel>(
        R.layout.activity_buy_or_sale_registration,
        BuyOrSaleRegistrationActivityViewModel::class.java
    ), View.OnClickListener {

    private val imageSourceImpl = ImageSourceImpl(this)

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

    override fun observeChanges() {
        super.observeChanges()
        viewModel.currentPrice.observe(this) {
            binding.etPrice.doOnTextChanged { text, start, before, count ->
                viewModel.setCurrentPrice(text.toString().toLong())
            }
        }
        viewModel.photoCardInfo.observe(this) {
            imageSourceImpl.getImageUrl(viewModel.photoCardInfo.value!!.imageUrl) {
                binding.ivPhoca.load(it)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, 0)
    }

    override fun onClick(v: View) {
        binding.apply {
            when (v) {
                btnBack -> {
                    onBackPressed()
                    finish()
                }
                btn10000 -> viewModel.setAddAmount(10000L)
                btn5000 -> viewModel.setAddAmount(5000L)
                btn1000 -> viewModel.setAddAmount(1000L)
                btn500 -> viewModel.setAddAmount(500L)
            }
        }
    }
}