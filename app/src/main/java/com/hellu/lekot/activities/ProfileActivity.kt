package com.hellu.lekot.activities

import android.graphics.Outline
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.hellu.lekot.R
import de.hdodenhof.circleimageview.CircleImageView
import net.theluckycoder.expandablecardview.ExpandableCardView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        supportActionBar?.let {
            it.title = "Profile"
            it.setDisplayHomeAsUpEnabled(true)
        }

        val imgProfile = findViewById<CircleImageView>(R.id.profile_image)
        val cardSkill = findViewById<ExpandableCardView>(R.id.card_skill)
        val cardCertificate = findViewById<ExpandableCardView>(R.id.card_certificate)
        val cardAward = findViewById<ExpandableCardView>(R.id.card_award)
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

        val url = "https://media-exp1.licdn.com/dms/image/C5603AQGujT6VG_WVew/profile-displayphoto-shrink_800_800/0?e=1604534400&v=beta&t=YYRTJZ9i0cd3IMAnvTPWLyPN7x97LbaNWnsHc5qtPd0"
        Glide.with(this).load(url).placeholder(R.mipmap.ic_launcher).fitCenter().dontAnimate().into(imgProfile);

        cardSkill.cardTitle = "Skill"
        cardSkill.cardDescription = "Kotlin Java"
        cardCertificate.cardTitle = "Certificate"
        cardCertificate.cardDescription = "IoT Architect, Flutter Expert, Golang Advance, Pengembangan ML"
        cardAward.cardTitle = "Award"
        cardAward.cardDescription = "Mawapres Vokasi IPB, 1st Thinkubator"
        cardHoby.cardTitle = "Hoby"
        cardHoby.cardDescription = "Basket, Badminton, Swimming"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
