package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class splash_activity extends AppCompatActivity {

    Button sub;
    ImageView balloon;
    Animation frombutton,fromtop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);

        sub=findViewById(R.id.sub);
        balloon=findViewById(R.id.balloon);

        frombutton= AnimationUtils.loadAnimation(this,R.anim.frombutton);
        fromtop=AnimationUtils.loadAnimation(this,R.anim.fromtop);
        balloon.setAnimation(fromtop);
        sub.setAnimation(frombutton);

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    startActivity(new Intent(splash_activity.this, MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread1.start();

    }
}
