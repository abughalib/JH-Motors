package com.jahid.hakim.jhmotors.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jahid.hakim.jhmotors.R

class HomeAdapter (private val bike_image: ArrayList<Int>,
                            private val bike_title: ArrayList<String>,
                            private val bike_desc: ArrayList<String>):
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val bikeImage: ImageView = itemView.findViewById(R.id.bike_image)
        val bikeTitle: TextView = itemView.findViewById(R.id.bike_title)
        val bikeDesc: TextView = itemView.findViewById(R.id.bike_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viewholder, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = bike_image.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bikeTitle.text = bike_title[position]
        holder.bikeDesc.text = bike_desc[position]
        holder.bikeImage.setImageResource(bike_image[position])
    }

}