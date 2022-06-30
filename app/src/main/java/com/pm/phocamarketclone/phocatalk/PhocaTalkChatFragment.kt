package com.pm.phocamarketclone.phocatalk

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pm.phocamarketclone.databinding.FragmentPhocaTalkChatBinding

/**
 * Created by charlie_Moon on 2022-06-30
 */
class PhocaTalkChatFragment : Fragment() {

    val binding by lazy { FragmentPhocaTalkChatBinding.inflate(layoutInflater) }

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