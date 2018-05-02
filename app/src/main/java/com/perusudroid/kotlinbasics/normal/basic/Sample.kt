package com.perusudroid.kotlinbasics.normal.basic

import android.util.Log

/**
 * Created by Intel on 24-04-2018.
 */
class Sample(name: String){

    private var TAG: String = "Sample"


    val firstProperty = "First Property : $name"

    init {
        Log.d(TAG, "Init method $firstProperty and new value is ${name.toUpperCase()}")

    }


}