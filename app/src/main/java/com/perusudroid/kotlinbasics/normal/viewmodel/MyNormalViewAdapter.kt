package com.perusudroid.kotlinbasics.normal.viewmodel

import android.databinding.DataBindingUtil
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.databinding.InflaterNormalViewmodelBinding
import com.perusudroid.kotlinbasics.databinding.InflaterViewMyBinding
import com.perusudroid.kotlinbasics.model.ListData
import com.squareup.picasso.Picasso


/**
 * Created by Intel on 27-04-2018.
 */
class MyNormalViewAdapter(var list: List<ListData>, var iListener: INormalListener) : RecyclerView.Adapter<MyNormalViewAdapter.ListBindingViewHolder>() {


    fun refresh(dataList: List<ListData>?) {
        list = dataList!!
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListBindingViewHolder {
        val binding: InflaterNormalViewmodelBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.inflater_normal_viewmodel, parent, false);
        return ListBindingViewHolder(binding, iListener)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListBindingViewHolder?, position: Int) {
        val listData: ListData = list[position]
        holder?.itemView?.tag = listData
        holder?.tvTxt?.text = listData.title
        Picasso.with(holder?.itemView?.context).load(listData.thumbnailUrl).into(holder?.ivPic)
    }


    class ListBindingViewHolder(binding: InflaterNormalViewmodelBinding, listener: INormalListener) : RecyclerView.ViewHolder(binding.root) {

        var ivPic: ImageView? = null
        var tvTxt: TextView? = null
        var rootLay: ConstraintLayout? = null

        init {
            ivPic = itemView.findViewById(R.id.image_photo_thumbnail)
            tvTxt = itemView.findViewById(R.id.text_photo_title)
            rootLay = itemView.findViewById(R.id.rootLay)
            rootLay?.setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }
        }

    }
}