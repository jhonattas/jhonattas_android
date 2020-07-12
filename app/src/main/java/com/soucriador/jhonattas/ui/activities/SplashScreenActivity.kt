package com.soucriador.jhonattas.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.soucriador.jhonattas.R

class SplashScreenActivity : AppCompatActivity(), Runnable {
    private val SPLASH_TIME_OUT = 1000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed(
                this@SplashScreenActivity,
                SPLASH_TIME_OUT
        )
    }

    override fun run() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}