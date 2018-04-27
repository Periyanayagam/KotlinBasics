package com.perusudroid.kotlinbasics.retro

import com.perusudroid.kotlinbasics.model.ListData
import com.perusudroid.kotlinbasics.model.SampleResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Intel on 27-04-2018.
 */
interface ApiInterface {
    @GET("kotlin.php")
    fun getSample() : Call<SampleResponse>

    @GET("photos")
    fun getData() : Call<List<ListData>>
}