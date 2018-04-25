package com.perusudroid.kotlinbasics.binding

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.databinding.InflaterBindingSampleBinding
import com.perusudroid.kotlinrecyclerview.binding.BindingData


/**
 * Created by Intel on 25-04-2018.
 */
class DataAdapter(val list: ArrayList<BindingData>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DataViewHolder {
        val binding: InflaterBindingSampleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.getContext()), R.layout.inflater_binding_sample, parent, false);
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DataViewHolder?, position: Int) {
        val bindingData: BindingData = list.get(position)
        holder?.bindingData?.bindingData = bindingData
    }

    class DataViewHolder(binding: InflaterBindingSampleBinding) : RecyclerView.ViewHolder(binding.root) {
        val bindingData: InflaterBindingSampleBinding? = binding
    }
}