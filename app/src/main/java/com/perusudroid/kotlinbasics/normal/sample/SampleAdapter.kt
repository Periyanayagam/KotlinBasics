package com.perusudroid.kotlinbasics.normal.sample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinrecyclerview.sample.SampleData

/**
 * Created by Intel on 25-04-2018.
 */

class SampleAdapter(val list: List<SampleData>) : RecyclerView.Adapter<SampleAdapter.SampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SampleViewHolder {
        return SampleViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.inflater_sample, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SampleViewHolder?, position: Int) {
        val sampleData: SampleData = list[position]
        holder?.tvOne?.text = sampleData.firstname
        holder?.tvTwo?.text = sampleData.lastname
    }

    class SampleViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val tvOne: TextView? = itemView?.findViewById(R.id.tvOne)
        val tvTwo: TextView? = itemView?.findViewById(R.id.tvTwo)
    }
}
