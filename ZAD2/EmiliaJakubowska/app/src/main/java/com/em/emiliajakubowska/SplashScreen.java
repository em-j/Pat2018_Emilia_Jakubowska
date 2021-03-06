package com.em.emiliajakubowska;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME = 5000;
    private static boolean SPLASH_STOP = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startMain();
            }
        }, SPLASH_TIME);
    }

    public void splashStop(View view) {
        SPLASH_STOP = false;
    }

    private void startMain() {
        if (SPLASH_STOP) {
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}

