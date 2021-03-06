package com.perusudroid.kotlinbasics

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.perusudroid.kotlinbasics.binding.list.ListActivity
import com.perusudroid.kotlinbasics.binding.login.LoginBindActivity
import com.perusudroid.kotlinbasics.binding.nav.LaunchBindingActivity
import com.perusudroid.kotlinbasics.normal.basic.BasicActivity
import com.perusudroid.kotlinbasics.normal.list.NormalListActivity
import com.perusudroid.kotlinbasics.normal.sample.SampleActivity
import com.perusudroid.kotlinbasics.binding.viewmodel.MyViewActivity
import com.perusudroid.kotlinbasics.normal.sharedpref.SharedPrefActivity
import com.perusudroid.kotlinbasics.normal.viewmodel.MyNormalViewActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private var btnNormalBasic: Button? = null
    private var btnNormalList: Button? = null
    private var btnNormalSample: Button? = null
    private var btnSample: Button? = null
    private var btnLogin: Button? = null
    private var btnList: Button? = null
    private var btnNav: Button? = null
    private var btnVM: Button? = null
    private var btnPref: Button? = null
    private var btnViewModel: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        setAssets()
    }

    private fun bindViews() {
        btnNormalBasic = findViewById(R.id.btnNormalBasic)
        btnNormalList = findViewById(R.id.btnNormalList)
        btnNormalSample = findViewById(R.id.btnNormalSample)
        btnSample = findViewById(R.id.btnSample)
        btnLogin = findViewById(R.id.btnLogin)
        btnList = findViewById(R.id.btnList)
        btnNav = findViewById(R.id.btnNav)
        btnVM = findViewById(R.id.btnVM)
        btnPref = findViewById(R.id.btnPref)
        btnViewModel = findViewById(R.id.btnViewModel)
    }

    private fun setAssets() {
        btnNormalBasic?.setOnClickListener(this)
        btnNormalList?.setOnClickListener(this)
        btnNormalSample?.setOnClickListener(this)
        btnSample?.setOnClickListener(this)
        btnLogin?.setOnClickListener(this)
        btnList?.setOnClickListener(this)
        btnNav?.setOnClickListener(this)
        btnVM?.setOnClickListener(this)
        btnPref?.setOnClickListener(this)
        btnViewModel?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNormalBasic -> startActivity(Intent(this, BasicActivity::class.java))
            R.id.btnNormalList -> startActivity(Intent(this, NormalListActivity::class.java))
            R.id.btnNormalSample -> startActivity(Intent(this, SampleActivity::class.java))
            R.id.btnSample -> startActivity(Intent(this, com.perusudroid.kotlinbasics.binding.sample.DataActivity::class.java))
            R.id.btnLogin -> startActivity(Intent(this, LoginBindActivity::class.java))
            R.id.btnList -> startActivity(Intent(this, ListActivity::class.java))
            R.id.btnNav -> startActivity(Intent(this, LaunchBindingActivity::class.java))
            R.id.btnVM -> startActivity(Intent(this, MyViewActivity::class.java))
            R.id.btnViewModel -> startActivity(Intent(this, MyNormalViewActivity::class.java))
            R.id.btnPref -> startActivity(Intent(this, SharedPrefActivity::class.java))
        }
    }
}
