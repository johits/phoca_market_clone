package com.pm.phocamarketclone.phocatalk

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.pm.phocamarketclone.R
import com.pm.phocamarketclone.databinding.FragmentPhocaTalkChatBinding

/**
 * Created by charlie_Moon on 2022-06-30
 */
class PhocaTalkChatFragment : Fragment() {

    private lateinit var binding: FragmentPhocaTalkChatBinding

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
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_phoca_talk_chat,
            container,
            false
        )
        return binding.root
    }
}