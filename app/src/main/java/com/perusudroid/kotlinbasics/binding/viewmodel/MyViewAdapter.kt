package com.perusudroid.kotlinbasics.binding.viewmodel

import android.databinding.DataBindingUtil
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.databinding.InflaterViewMyBinding
import com.perusudroid.kotlinbasics.model.ListData


/**
 * Created by Intel on 27-04-2018.
 */
class MyViewAdapter(var list: List<ListData>, var iListener: IListener) : RecyclerView.Adapter<MyViewAdapter.ListBindingViewHolder>() {


    fun refresh(dataList: List<ListData>?) {
        list = dataList!!
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListBindingViewHolder {
        val binding: InflaterViewMyBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.inflater_view_my, parent, false);
        return ListBindingViewHolder(binding, iListener)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListBindingViewHolder?, position: Int) {
        val bindingData: ListData = list[position]
        holder?.bindingData?.albumData = bindingData
        holder?.bindingData?.callback = iListener
        holder?.bindingData?.executePendingBindings()
    }


    class ListBindingViewHolder(binding: InflaterViewMyBinding, listener: IListener) : RecyclerView.ViewHolder(binding.root) {

        var rootLay: ConstraintLayout? = null
        var bindingData: InflaterViewMyBinding? = binding

        init {
            rootLay = bindingData?.rootLay
            rootLay?.setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }
        }

    }
}