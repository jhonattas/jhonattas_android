package com.soucriador.jhonattas.ui.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.soucriador.jhonattas.R;

public class SplashScreenActivity extends AppCompatActivity implements Runnable {

    private final Long SPLASH_TIME_OUT = 3000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(
                SplashScreenActivity.this,
                SPLASH_TIME_OUT
        );
    }


    @Override
    public void run() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
