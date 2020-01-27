package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class wrong_answer extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wrong_answer);
        //LottieAnimationView lot=findViewById(R.id.animation_view);
        //lot.setAnimation("trophy.json");
       // lot.loop(true);
      //  lot.playAnimation();
        Intent intent=getIntent();
        int right=intent.getIntExtra("right",0);
        TextView boo = findViewById(R.id.finale);
        btn1=findViewById(R.id.home);
        boo.setText("Arrgh...You only scored "+right+" out of 15.Try again!");
        btn1.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.home:
                openhome();
                break;
        }
    }
    @Override
    public void onBackPressed() {

    }
    private void openhome()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }

}
