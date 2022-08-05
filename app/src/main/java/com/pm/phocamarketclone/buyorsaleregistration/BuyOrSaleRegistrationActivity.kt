package com.pm.phocamarketclone.buyorsaleregistration

import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.base.BaseViewModelActivity
import com.pm.phocamarketclone.databinding.ActivityBuyOrSaleRegistrationBinding

class BuyOrSaleRegistrationActivity :
    BaseViewModelActivity<ActivityBuyOrSaleRegistrationBinding, BuyOrSaleRegistrationActivityViewModel>(
        R.layout.activity_buy_or_sale_registration,
        BuyOrSaleRegistrationActivityViewModel::class.java
    ) {
}