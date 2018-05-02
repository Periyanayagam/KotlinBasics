package com.perusudroid.kotlinbasics.normal.basic

import android.content.Context

/**
 * Created by Intel on 25-04-2018.
 */
class MultipleDataProcessor : IDataPropertyOne, IDataPropertyTwo {

    override fun showMsg(msg: String, context: Context) {
        super<IDataPropertyOne>.showMsg(msg, context)
        super<IDataPropertyTwo>.showMsg(msg, context)
    }
}