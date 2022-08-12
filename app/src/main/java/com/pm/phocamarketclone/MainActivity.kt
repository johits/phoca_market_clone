package com.pm.phocamarketclone

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.pm.phocamarketclone.databinding.ActivityMainBinding
import com.pm.phocamarketclone.mypage.MyPageFragment
import com.pm.phocamarketclone.phocatalk.PhocaTalkFragment
import com.pm.phocamarketclone.search.SearchFragment
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    private val searchFragment = SearchFragment()
    private val talkFragment = PhocaTalkFragment()
    private val myPageFragment = MyPageFragment()
    val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewInit()
//        for (i in 1..3){
//            add(i)
//        }
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

    fun add(i:Int){
        val photoCard: MutableMap<String, Any> = HashMap()
        photoCard["cardName"] = "TXT Version."
        photoCard["group"] = "TXT"
        photoCard["heart"] = false
        photoCard["imageUrl"] = "연준$i.jfif"
        photoCard["member"] = "연준"
        photoCard["recentPrice"] = 1000

        db.collection("photocardlist")
            .add(photoCard)
            .addOnSuccessListener( { documentReference ->
                Log.d(
                    "jhs",
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
            })
            .addOnFailureListener(OnFailureListener { e -> Log.w("jhs", "Error adding document", e) })
    }
}