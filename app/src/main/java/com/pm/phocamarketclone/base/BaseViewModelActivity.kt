package com.pm.phocamarketclone.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModelActivity<B : ViewDataBinding, VM : ViewModel>(
    @LayoutRes private val layoutResId: Int,
    private val viewModelCls: Class<out ViewModel>
) : AppCompatActivity() {

    protected lateinit var binding: B
        private set

    protected lateinit var viewModel: VM
        private set

    open fun onInitBinding() {}
    open fun observeChanges() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        viewModel = ViewModelProvider(this)[viewModelCls] as VM
        onInitBinding()
        observeChanges()
    }
}