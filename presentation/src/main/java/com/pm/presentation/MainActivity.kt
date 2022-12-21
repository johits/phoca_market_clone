package com.pm.presentation

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import com.pm.presentation.databinding.ActivityMainBinding
import com.pm.presentation.mypage.MyPageFragment
import com.pm.presentation.phocatalk.PhocaTalkFragment
import com.pm.presentation.search.SearchFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val searchFragment = SearchFragment()
    private val talkFragment = PhocaTalkFragment()
    private val myPageFragment = MyPageFragment()
    val db = FirebaseFirestore.getInstance()

    private val ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE = 1

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewInit()
        checkPermission()
        Log.d("jhs", "인터넷 연결 체크 상태:${isConnectInternet()}")

        //서비스 시작
        var intent = Intent(this, MyFirebaseMessaging::class.java)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.startForegroundService(intent)
        } else {
            this.startService(intent)
        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("jhs", "getInstanceId failed", task.exception)
                return@OnCompleteListener
            }

            // Get new Instance ID token
            val token = task.result

            Log.d("jhs", "토큰:$token")
            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        processcommand(intent)
    }

    private fun processcommand(intent: Intent) {
        if (intent != null) {
            if (intent?.action == "test") {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.apply {
                    setTitle(intent.getStringExtra("title"))
                    setMessage(intent.getStringExtra("body"))
                    setPositiveButton("확인", null)
                    show()
                }
            }
        }
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

    private fun isConnectInternet(): String { // 인터넷 연결 체크 함수
        val cm: ConnectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = cm.activeNetworkInfo
        return networkInfo.toString()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fl_fragment, fragment).commit()
    }

    fun add(i: Int) {
        val photoCard: MutableMap<String, Any> = HashMap()
        photoCard["cardName"] = "TXT Version."
        photoCard["group"] = "TXT"
        photoCard["heart"] = false
        photoCard["imageUrl"] = "연준$i.jfif"
        photoCard["member"] = "연준"
        photoCard["recentPrice"] = 1000

        db.collection("photocardlist")
            .add(photoCard)
            .addOnSuccessListener({ documentReference ->
                Log.d(
                    "jhs",
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
            })
            .addOnFailureListener(OnFailureListener { e ->
                Log.w(
                    "jhs",
                    "Error adding document",
                    e
                )
            })
    }

    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {   // 마시멜로우 이상일 경우
            if (!Settings.canDrawOverlays(this)) {              // 다른앱 위에 그리기 체크
                val uri: Uri = Uri.fromParts("package", packageName, null)
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, uri)
                startActivityForResult(intent, ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE)
            } else {
                startMain()
            }
        } else {
            startMain()
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE) {
            if (!Settings.canDrawOverlays(this)) {
                finish()
            } else {
                startMain()
            }
        }
    }

    private fun startMain() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(Intent(this, MyFirebaseMessaging::class.java))
        } else {
            startService(Intent(this, MyFirebaseMessaging::class.java))
        }
    }
}