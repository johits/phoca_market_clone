package com.pm.phocamarketclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pm.phocamarketclone.databinding.ActivityMainBinding
import com.pm.phocamarketclone.mypage.MyPageFragment

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val myPageFragment = MyPageFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewInit()

    }

    private fun viewInit(){
        supportFragmentManager.beginTransaction().add(R.id.fl_fragment, TODO("need SearchFragment")).commit()

        binding.bnavMain.setOnItemSelectedListener {
            when (it.itemId) {
//                TODO("need replace SearchFragment")->{}
                R.id.nav_my_page -> {
                    replaceFragment(myPageFragment)
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fl_fragment, fragment).commit()
    }
}