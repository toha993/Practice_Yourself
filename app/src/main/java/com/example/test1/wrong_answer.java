package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class wrong_answer extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_answer);
        //LottieAnimationView lot=findViewById(R.id.animation_view);
        //lot.setAnimation("trophy.json");
       // lot.loop(true);
      //  lot.playAnimation();
        TextView boo = findViewById(R.id.finale);
        btn1=findViewById(R.id.home);
        boo.setText("Arrgh...");
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
    }

}
