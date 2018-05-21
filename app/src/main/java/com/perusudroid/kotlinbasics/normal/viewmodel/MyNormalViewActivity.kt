package com.perusudroid.kotlinbasics.normal.viewmodel

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

class MyNormalViewActivity : AppCompatActivity(), INormalListener {

    private var binding: ActivityMyViewBinding? = null
    private var viewModel: MyNormalViewModel? = null
    private var adapter: MyNormalViewAdapter? = null
    private var dataList: MutableList<ListData>? = null
    private val TAG = MyNormalViewActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_view)
        setAssets()
        viewModel = ViewModelProviders.of(this).get(MyNormalViewModel::class.java)
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
                        adapter = MyNormalViewAdapter(dataList!!, this@MyNormalViewActivity)
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
