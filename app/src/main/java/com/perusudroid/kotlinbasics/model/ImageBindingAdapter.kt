package com.perusudroid.kotlinbasics.model

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Intel on 27-04-2018.
 */
object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view: ImageView, url: String) {
        Picasso.with(view.context).load(url).into(view)
    }
}