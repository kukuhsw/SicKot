package com.hellu.lekot.activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
        val btnShare: Button = findViewById(R.id.btn_share)


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

        btnShare.setOnClickListener {
            shareToWhatsApps(people?.photo, pName)
        }

    }

    private fun shareToWhatsApps(photo: Int?, pName: String) {
        var imageUri: Uri? = null
        try {
            imageUri = Uri.parse(
                MediaStore.Images.Media.insertImage(
                    contentResolver,
                    photo?.let { BitmapFactory.decodeResource(resources, it) }, null, null
                )
            )
        } catch (e: NullPointerException) {
            Toast.makeText(this, "Gambar tidak bisa di share", Toast.LENGTH_SHORT).show()
        }
        val whatsappIntent = Intent(Intent.ACTION_SEND)
        whatsappIntent.type = "/"
        whatsappIntent.putExtra(Intent.EXTRA_STREAM, imageUri)
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, pName)
        whatsappIntent.setPackage("com.whatsapp")

        try {
            startActivity(whatsappIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, "Whatsapp belum di-install.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
