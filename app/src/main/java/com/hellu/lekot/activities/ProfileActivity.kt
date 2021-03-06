package com.hellu.lekot.activities

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        showPhotoProfile(imgProfile)
        showCardSkill(cardSkill)
        showCardCertificate(cardCertificate)
        showCardAward(cardAward)
        showCardHoby(cardHoby)

    }

    private fun showPhotoProfile(imgProfile: CircleImageView?) {
        val url =
            "https://media-exp1.licdn.com/dms/image/C5603AQGujT6VG_WVew/profile-displayphoto-shrink_800_800/0?e=1604534400&v=beta&t=YYRTJZ9i0cd3IMAnvTPWLyPN7x97LbaNWnsHc5qtPd0"
        if (imgProfile != null) {
            Glide.with(this).load(url).placeholder(R.mipmap.ic_launcher).fitCenter().dontAnimate()
                .into(imgProfile)
        }
    }

    private fun showCardHoby(mCardHoby: ExpandableCardView) {
        mCardHoby.cardTitle = "Hoby"
        mCardHoby.cardDescription = "Basket, Badminton, Swimming"
        mCardHoby.setBackgroundColor(Color.parseColor("#B3FFAB"))
    }

    private fun showCardAward(mCardAward: ExpandableCardView) {
        mCardAward.cardTitle = "Award"
        mCardAward.cardDescription = "Mawapres Vokasi IPB, 1st Thinkubator"
        mCardAward.setBackgroundColor(Color.parseColor("#fd746c"))
    }

    private fun showCardCertificate(mCardCertificate: ExpandableCardView) {
        mCardCertificate.cardTitle = "Certificate"
        mCardCertificate.cardDescription =
            "IoT Architect, Flutter Expert, Golang Advance, Pengembangan ML"
        mCardCertificate.setBackgroundColor(Color.parseColor("#ffcc33"))
    }

    private fun showCardSkill(mCardSkill: ExpandableCardView) {
        mCardSkill.cardTitle = "Skill"
        mCardSkill.cardDescription = "Kotlin Java"
        mCardSkill.setBackgroundColor(Color.parseColor("#9796f0"))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
