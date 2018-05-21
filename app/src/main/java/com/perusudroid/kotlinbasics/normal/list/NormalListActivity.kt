package com.perusudroid.kotlinbasics.normal.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.model.ListData
import com.perusudroid.kotlinbasics.retro.ApiClient
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NormalListActivity : AppCompatActivity(), Callback<List<ListData>>, IClickListener {


    private var recyclerView: RecyclerView? = null
    private var listData: MutableList<ListData>? = null
    private var adapter: NormalListAdapter? = null
    private var pBar : ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_list)
        bindViews()
        setAssets()
    }


    private fun bindViews() {
        listData = ArrayList()
        recyclerView = findViewById(R.id.recyclerView)
        pBar = findViewById(R.id.pBar)
    }


    private fun setAssets() {
        recyclerView?.layoutManager = LinearLayoutManager(this)
        ApiClient.apiInterface.getData().enqueue(this)
    }

    override fun onResponse(call: Call<List<ListData>>?, response: Response<List<ListData>>?) {
        if (response!!.isSuccessful) {
            if (response.body() != null) {
                pBar?.visibility = View.GONE
                listData = response.body() as MutableList<ListData>
                adapter = NormalListAdapter(listData!!, this)
                recyclerView?.adapter = adapter
            }
        }
    }

    override fun onFailure(call: Call<List<ListData>>?, t: Throwable?) {
        Log.d("API", t?.localizedMessage)
    }

    override fun onItemClick(listDatax: ListData, adapterPosition: Int) {
        listData?.removeAt(adapterPosition)
        adapter?.refresh(listData)
        toast("Removed  ${listDatax.title}")
    }

}
