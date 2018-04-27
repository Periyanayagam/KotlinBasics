package com.perusudroid.kotlinbasics.retro

import com.perusudroid.kotlinbasics.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Intel on 27-04-2018.
 */
object ApiClient {

    val apiInterface: ApiInterface

    //https://jsonplaceholder.typicode.com

    // php file included in source code
    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(getHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    init {
        apiInterface = retrofit.create(ApiInterface::class.java)
    }


    private fun getHttpClient() = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor())
            .build()

    fun headersInterceptor() = Interceptor { chain ->
        chain.proceed(chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Accept-Language", "en")
                .addHeader("Content-Type", "application/json")
                .build())
    }

    private fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }


}