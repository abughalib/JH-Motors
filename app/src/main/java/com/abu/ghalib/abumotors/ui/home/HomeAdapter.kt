package com.abu.ghalib.abumotors.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.abu.ghalib.abumotors.databinding.ItemViewholderBinding
import com.abu.ghalib.abumotors.ui.network.AppProperty

class HomeAdapter: ListAdapter<AppProperty, HomeAdapter.MyViewHolder>(DiffCallback) {

class MyViewHolder(private var binding: ItemViewholderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(appProperty: AppProperty) {
            binding.property = appProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemViewholderBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val appProperty = getItem(position)
        holder.bind(appProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<AppProperty>() {
        override fun areItemsTheSame(oldItem: AppProperty, newItem: AppProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: AppProperty, newItem: AppProperty): Boolean {
            return oldItem.id == newItem.id
        }

    }
}
