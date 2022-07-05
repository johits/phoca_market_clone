package com.pm.phocamarketclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.pm.phocamarketclone.databinding.ActivityMainBinding
import com.pm.phocamarketclone.mypage.MyPageFragment
import com.pm.phocamarketclone.phocatalk.PhocaTalkFragment
import com.pm.phocamarketclone.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val searchFragment = SearchFragment()
    private val talkFragment = PhocaTalkFragment()
    private val myPageFragment = MyPageFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewInit()

    }

    private fun viewInit() {
        supportFragmentManager.beginTransaction().add(R.id.fl_fragment, searchFragment).commit()
        binding.bnavMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_phoca_find -> replaceFragment(searchFragment)
                R.id.nav_phoca_talk -> replaceFragment(talkFragment)
                R.id.nav_my_page -> replaceFragment(myPageFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fl_fragment, fragment).commit()
    }
}