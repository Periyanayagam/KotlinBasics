package com.perusudroid.kotlinbasics.binding.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.perusudroid.kotlinbasics.model.ListData
import com.perusudroid.kotlinbasics.retro.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel : ViewModel(), Callback<List<ListData>> {

    private var mList: MutableLiveData<List<ListData>>? = null

    fun getData(): LiveData<List<ListData>>? {
        if (mList == null) {
            mList = MutableLiveData()
            ApiClient.apiInterface.getData().enqueue(this)
        }
        return mList
    }

    fun updateData(listData: List<ListData>?) {
        if (mList != null) {
            mList?.value = listData
        }
    }

    override fun onResponse(call: Call<List<ListData>>?, response: Response<List<ListData>>?) {
        mList?.value = response?.body()
    }

    override fun onFailure(call: Call<List<ListData>>?, t: Throwable?) {

    }


}