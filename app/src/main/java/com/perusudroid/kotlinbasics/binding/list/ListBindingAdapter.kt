package com.perusudroid.kotlinbasics.binding.list

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.databinding.InflaterAlbumItemBinding
import com.perusudroid.kotlinbasics.databinding.InflaterBindingSampleBinding
import com.perusudroid.kotlinbasics.model.ListData
import com.perusudroid.kotlinrecyclerview.binding.BindingData

/**
 * Created by Intel on 27-04-2018.
 */
class ListBindingAdapter(var list: List<ListData>): RecyclerView.Adapter<ListBindingAdapter.ListBindingViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListBindingViewHolder {
       val binding: InflaterAlbumItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.getContext()), R.layout.inflater_album_item, parent, false);
        return ListBindingViewHolder(binding)
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: ListBindingViewHolder?, position: Int) {
        val bindingData: ListData = list.get(position)
        holder?.bindingData?.albumData = bindingData
    }


    class ListBindingViewHolder(binding : InflaterAlbumItemBinding) : RecyclerView.ViewHolder(binding.root){
        val bindingData: InflaterAlbumItemBinding? = binding
    }
}