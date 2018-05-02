package com.perusudroid.kotlinbasics.binding.sample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.perusudroid.kotlinbasics.R

import com.perusudroid.kotlinbasics.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data)
        binding.rView.layoutManager = LinearLayoutManager(this);

        val mList = ArrayList<BindingData>()
        mList.add(BindingData("Perusudroid", "Binding"))
        mList.add(BindingData("Binding", "Kotlin"))

        binding.rView.adapter = DataAdapter(mList)

    }
}
