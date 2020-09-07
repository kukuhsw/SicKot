package com.hellu.lekot.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

//        inisialisasi textview data deskripsi
        val tvAge: TextView = findViewById(R.id.desc_text_age)
        val tvTemp: TextView = findViewById(R.id.desc_text_temp)
        val tvDiameter: TextView = findViewById(R.id.desc_text_diameter)
        val tvWeight: TextView = findViewById(R.id.desc_text_weight)


        val people = intent.getSerializableExtra("planet") as? Planet
        val pPhoto = people?.photo
        val pName = people?.name.toString()
        val pDetail = people?.address.toString()

//        get data
        val descAge = people?.age?.toString()
        val descTemp = people?.surfaceTemp?.toString()
        val descDiameter = people?.diameter?.toString()
        val descWeight = people?.mass?.toString()

        textPlanet.text = pName
        Glide.with(this)
            .load(pPhoto)
            .apply(RequestOptions())
            .into(imgPlanet)
        textDescription.text = pDetail

        tvAge.text = "age :$descAge"
        tvTemp.text = "temperature $descTemp"
        tvDiameter.text = "diameter: $descDiameter"
        tvWeight.text = "weight: $descWeight"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
