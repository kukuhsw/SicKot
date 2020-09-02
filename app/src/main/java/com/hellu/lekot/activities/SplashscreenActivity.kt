package com.hellu.lekot.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
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
