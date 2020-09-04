package com.hellu.lekot.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hellu.lekot.R
import com.hellu.lekot.data.Planet

class DetailPlanetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_planet)

        supportActionBar?.let {
            it.title = "Detail Planet"
            it.setDisplayHomeAsUpEnabled(true)
        }

        val textPlanet: TextView = findViewById(R.id.planet_name)
        val imgPlanet: ImageView = findViewById(R.id.planet_photo)
        val textDescription: TextView = findViewById(R.id.planet_description)

        val people = intent.getSerializableExtra("planet") as? Planet
        val pPhoto = people?.photo?.toInt()
        val pName = people?.name.toString()
        val pDetail = people?.address.toString()

        textPlanet.text = pName
        Glide.with(this)
            .load(pPhoto)
            .apply(RequestOptions())
            .into(imgPlanet)
        textDescription.text = pDetail


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
