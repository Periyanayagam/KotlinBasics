package com.perusudroid.kotlinbasics.normal.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.model.ListData
import com.squareup.picasso.Picasso

class NormalListAdapter(val list: List<ListData>) : RecyclerView.Adapter<NormalListAdapter.NormalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NormalViewHolder =
            NormalViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.inflater_album_item, parent, false))

    /*
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NormalViewHolder {
        return NormalViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.inflater_album_item, parent, false))
    }*/

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NormalViewHolder?, position: Int) {
        val listData : ListData = list[position]
        holder?.tvTxt?.text = listData.title
        Picasso.with(holder?.itemView?.context).load(listData.thumbnailUrl).into(holder?.ivPic)
    }

    class NormalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivPic: ImageView? = null
        var tvTxt: TextView? = null
        init {
            ivPic = itemView.findViewById(R.id.image_photo_thumbnail)
            tvTxt = itemView.findViewById(R.id.text_photo_title)
        }
    }
}