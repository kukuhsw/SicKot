package com.hellu.lekot.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.hellu.lekot.R
import com.hellu.lekot.data.Planet
import com.hellu.lekot.utils.OnClickListener
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class HomeAdapter(private var userList: ArrayList<Planet>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    private var listener: OnClickListener? = null

    fun setListener(onClickListener: OnClickListener) {
        this.listener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_large_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position])
        holder.itemView.setOnClickListener {
            if (listener != null) {
                listener!!.onClickEvent(userList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: Planet) {
            val cardBackground = itemView.findViewById<RelativeLayout>(R.id.card_large_planet)
            val tvName = itemView.findViewById<TextView>(R.id.tv_item_name)
            val ivPlanet = itemView.findViewById<CircleImageView>(R.id.iv_item_photo)

            if (position % 2 == 1) {
                cardBackground.setBackgroundColor(Color.parseColor("#ffee93"))
            } else {
                cardBackground.setBackgroundColor(Color.parseColor("#adf7b6"))
            }

            tvName?.text = user.name
            Glide.with(itemView.context)
                .load(user.photo)
                .thumbnail(0.5f)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivPlanet)
        }
    }


    fun filterList(filteredNames: ArrayList<Planet>) {
        this.userList = filteredNames
        notifyDataSetChanged()
    }
}