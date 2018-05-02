package com.perusudroid.kotlinbasics.normal.basic

import android.content.Context
import android.widget.Toast


/**
 * Created by Intel on 25-04-2018.
 */
class DataProcessor : IData {

    override fun doSomething(name: String, context: Context) {
        Toast.makeText(context, name, Toast.LENGTH_LONG).show();
    }


}