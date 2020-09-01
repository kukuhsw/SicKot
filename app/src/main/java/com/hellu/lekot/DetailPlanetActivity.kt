package com.hellu.lekot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hellu.lekot.data.Galaxy

class DetailPlanetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_planet)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Planet"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val textPlanet: TextView = findViewById(R.id.planet_name)
        val imgPlanet: ImageView = findViewById(R.id.planet_photo)
        val textDescription: TextView = findViewById(R.id.planet_description)

        val data = intent.extras
        val galaxy = data?.getParcelable<Galaxy>("planet")
        val planetPhoto = galaxy?.photo?.toInt()
        val planetName = galaxy?.planetName.toString()
        val planetDetail = galaxy?.planetDetail.toString()

        textPlanet.text = planetName
        Glide.with(this)
            .load(planetPhoto)
            .apply(RequestOptions())
            .into(imgPlanet)
        textDescription.text = planetDetail

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
