package com.hellu.lekot.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.hellu.lekot.R

class SplashscreenActivity : AppCompatActivity() {

    private val SPLASHTIME : Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } , SPLASHTIME
        )
    }
}
