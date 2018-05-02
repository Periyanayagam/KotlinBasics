package com.perusudroid.kotlinbasics.binding.list

import com.perusudroid.kotlinbasics.model.ListData

/**
 * Created by Intel on 02-05-2018.
 */
interface IListener {

    fun onItemClicked(listData : ListData)

}