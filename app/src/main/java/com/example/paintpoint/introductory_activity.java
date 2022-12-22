package com.example.paintpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class introductory_activity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000;

    Animation topAnim,bottomAni;
    ImageView image,splash;
    TextView nameapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
        setContentView(R.layout.activity_introductory);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAni = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image = findViewById(R.id.logo);
        splash = findViewById(R.id.splash);
        nameapp = findViewById(R.id.name_app);

        image.setAnimation(topAnim);
        splash.setAnimation(topAnim);
        nameapp.setAnimation(bottomAni);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(introductory_activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}