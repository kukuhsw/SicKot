package com.hellu.lekot.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hellu.lekot.R
import com.hellu.lekot.OnClickListener
import com.hellu.lekot.data.Planet
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by Govind on 3/19/2018.
 */
class PlanetAdapter(private var userList: ArrayList<Planet>) : RecyclerView.Adapter<PlanetAdapter.ViewHolder>() {
    private var listener: OnClickListener? = null

    fun setListener(onClickListener: OnClickListener) {
        this.listener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_galaxy, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position])
        //Custom OnClickListener Event
        holder.itemView.setOnClickListener(View.OnClickListener {
            if (listener != null) {
                listener!!.onClickEvent(userList[position])
            }
        })
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: Planet) {
            val tvName = itemView.findViewById<TextView>(R.id.tv_item_name)
            val tvDescription = itemView.findViewById<TextView>(R.id.tv_item_detail)
            val ivPlanet = itemView.findViewById<CircleImageView>(R.id.img_item_photo)

            tvName?.text = user.name
            tvDescription?.text = user.address
            Glide.with(itemView.context)
                .load(user.photo)
                .apply(RequestOptions().override(55, 55))
                .into(ivPlanet)

        }
    }

    /*This method will filter the list and here we are passing the filtered data
        and assigning it to the list with notifyDataSetChanged method
    */
    fun filterList(filteredNames: ArrayList<Planet>) {
        this.userList = filteredNames
        notifyDataSetChanged()
    }
}
