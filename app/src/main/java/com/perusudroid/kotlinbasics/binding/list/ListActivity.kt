package com.perusudroid.kotlinbasics.binding.list

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.databinding.ActivityListBinding
import com.perusudroid.kotlinbasics.model.ListData
import com.perusudroid.kotlinbasics.retro.ApiClient
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity : AppCompatActivity(), Callback<List<ListData>>, IListener {

    private var binding: ActivityListBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        setAssets()
    }

    private fun setAssets() {
        binding?.rView?.layoutManager = LinearLayoutManager(this)
        ApiClient.apiInterface.getData().enqueue(this)
    }

    override fun onResponse(call: Call<List<ListData>>?, response: Response<List<ListData>>?) {
        if (response!!.isSuccessful) {
            if (response.body() != null) {
                binding?.rView?.adapter = ListBindingAdapter(response.body() as List<ListData>, this)
            }
        }
    }

    override fun onFailure(call: Call<List<ListData>>?, t: Throwable?) {
        Log.d("API", t?.localizedMessage)
    }

    override fun onItemClicked(listData: ListData) {
        toast("Clicked ${listData.title}")
    }
}

