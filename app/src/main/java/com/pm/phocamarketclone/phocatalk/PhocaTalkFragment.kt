package com.pm.phocamarketclone.phocatalk

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pm.phocamarketclone.databinding.FragmentPhocaTalkBinding

/**
 * Created by charlie_moon on 2022-06-30
 */
class PhocaTalkFragment : Fragment() {

    val binding by lazy { FragmentPhocaTalkBinding.inflate(layoutInflater) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return binding.root
    }
}