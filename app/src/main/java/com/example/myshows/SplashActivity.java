package com.example.myshows;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    MediaPlayer mpIntro;
    int playing;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mpIntro = new MediaPlayer();
        mpIntro = MediaPlayer.create(this, R.raw.intro);

        CountDownTimer cntr_aCounter = new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {

                mpIntro.start();
            }

            public void onFinish() {
                //code fire after finish
                mpIntro.stop();
            }
        };cntr_aCounter.start();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, ItemsListActivity.class));
            }
        };
        Timer opening = new Timer();
        opening.schedule(task, 5000);
    }
}