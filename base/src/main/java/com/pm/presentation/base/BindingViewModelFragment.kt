package com.pm.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BindingViewModelFragment<B : ViewDataBinding, VM : ViewModel>(
    @LayoutRes private val layoutResId: Int,
    private val viewModelCls: Class<out ViewModel>,
) : Fragment() {
    lateinit var binding: B
        private set
    lateinit var viewModel: VM
        private set


    open fun onInitBinding() {}
    open fun observerChanges() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        viewModel = ViewModelProvider(this)[viewModelCls] as VM
        onInitBinding()
        observerChanges()
        return binding.root
    }
}