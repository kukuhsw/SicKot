package com.hellu.lekot.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hellu.lekot.R
import com.hellu.lekot.data.PlanetData

class RecyclerViewAdapter(context: Context, list: ArrayList<PlanetData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    private val context: Context = context
    var list: ArrayList<PlanetData> = list

    private inner class View1ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var svNamePlanet: TextView = itemView.findViewById(R.id.tv_item_name)
        var svDetail:TextView = itemView.findViewById(R.id.tv_item_detail)
        fun bind(position: Int) {
            val recyclerViewModel = list[position]
            svNamePlanet.text = recyclerViewModel.name
            svDetail.text = recyclerViewModel.address
        }
    }

    private inner class View2ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_item_name)
        var detail: TextView = itemView.findViewById(R.id.tv_item_detail)
        fun bind(position: Int) {
            val recyclerViewModel = list[position]
            name.text = recyclerViewModel.name
            detail.text = recyclerViewModel.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ONE) {
            return View1ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_row_galaxy, parent, false)
            )
        }
        return View2ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_large_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (list[position].viewType === VIEW_TYPE_ONE) {
            (holder as View1ViewHolder).bind(position)
        } else {
            (holder as View2ViewHolder).bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }
}