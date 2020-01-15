package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Congratulations extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            YourPreference yourPrefrence = YourPreference.getInstance(this);
            setContentView(R.layout.activity_congratulations);
            TextView boo = findViewById(R.id.finale);
            btn1=findViewById(R.id.home);
            Intent intent = getIntent();
            int chapter = intent.getIntExtra("chapter", 0);
            int right = intent.getIntExtra("result", 0);
            System.out.println(right);
            System.out.println(chapter);
            chapter++;
            String xd = String.valueOf(chapter);
            if (right >= 0) {
                System.out.println(yourPrefrence.unlock(xd));
                yourPrefrence.updt(xd, 1);
                System.out.println(yourPrefrence.unlock(xd));
            }
            boo.setText("Hurrah...You have unlocked the Chapter "+chapter+".\nYour Score is "+right+" out of 15.");
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
