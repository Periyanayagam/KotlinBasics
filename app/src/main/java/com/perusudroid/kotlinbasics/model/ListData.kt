package com.perusudroid.kotlinbasics.model

import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatImageView
import android.widget.ImageView
import com.perusudroid.kotlinbasics.R
import com.squareup.picasso.Picasso

/**
 * Created by Intel on 27-04-2018.
 */
class ListData(
        var _id: Int = -1,
        var albumId: Int = -1,
        var title: String? = null,
        var url: String? = null,
        var thumbnailUrl: String? = null

){

}