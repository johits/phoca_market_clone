package com.pm.phocamarketclone.phocatalk

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.databinding.FragmentPhocaTalkBinding

/**
 * Created by charlie_moon on 2022-06-30
 */
class PhocaTalkFragment : Fragment() {

    private lateinit var binding: FragmentPhocaTalkBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_phoca_talk, container, false)

        return binding.root
    }
}