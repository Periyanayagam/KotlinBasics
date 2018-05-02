package com.perusudroid.kotlinbasics.normal.basic

import android.content.Context
import android.widget.Toast

/**
 * Created by Intel on 25-04-2018.
 */
interface IDataPropertyTwo {

    fun showMsg(msg: String, context: Context) {
        Toast.makeText(context, "IDataPropertyTwo $msg", Toast.LENGTH_LONG).show()
    }

}