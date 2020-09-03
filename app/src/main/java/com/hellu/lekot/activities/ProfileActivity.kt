package com.hellu.lekot.activities

import android.graphics.Outline
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import com.hellu.lekot.R
import net.theluckycoder.expandablecardview.ExpandableCardView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val actionbar = supportActionBar
        actionbar!!.title = "Profile"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val cardSkill = findViewById<ExpandableCardView>(R.id.card_skill)
        val cardHoby = findViewById<ExpandableCardView>(R.id.card_hoby)
        val image = findViewById<CardView>(R.id.cardView)
        val curveRadius = 40F

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            image.outlineProvider = object : ViewOutlineProvider() {

                @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
                override fun getOutline(view: View?, outline: Outline?) {
                    outline?.setRoundRect(0, 0, view!!.width, (view.height+curveRadius).toInt(), curveRadius)
                }
            }

            image.clipToOutline = true

        }

        cardSkill.cardTitle = "Skill"
        cardSkill.cardDescription = "Kotlin Java"
        cardSkill.setAction("Action", View.OnClickListener {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        })

        cardHoby.cardTitle = "Hoby"
        cardHoby.cardDescription = "Basket, Badminton, Swimming"
        cardHoby.setAction("Action", View.OnClickListener {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
