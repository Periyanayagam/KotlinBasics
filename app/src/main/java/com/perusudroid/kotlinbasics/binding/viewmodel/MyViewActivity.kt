package com.perusudroid.kotlinbasics.binding.viewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.databinding.ActivityMyViewBinding
import com.perusudroid.kotlinbasics.model.ListData

class MyViewActivity : AppCompatActivity(), IListener {

    private var binding: ActivityMyViewBinding? = null
    private var viewModel: MyViewModel? = null
    private var adapter: MyViewAdapter? = null
    private var dataList: MutableList<ListData>? = null
    private val TAG = MyViewActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_view)
        setAssets()
        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        bindData()

    }

    private fun setAssets() {
        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    private fun bindData() {

        viewModel?.getData()?.observe(
                this,
                Observer<List<ListData>> { newDataList ->
                    dataList = newDataList as MutableList<ListData>?
                    Log.d(TAG, "onChanged: ")
                    if (adapter == null) {
                        binding?.pBar?.visibility = View.GONE
                        adapter = MyViewAdapter(dataList!!, this@MyViewActivity)
                        binding?.recyclerView?.adapter = adapter
                        Log.d(TAG, "adapter set")
                    } else {
                        Log.d(TAG, "adapter refresh")
                        adapter?.refresh(dataList)
                    }
                }
        )

    }


    override fun onItemClicked(position: Int) {
        dataList?.removeAt(position)
        viewModel?.updateData(dataList)
    }

}
