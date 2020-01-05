package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Congratulations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        YourPreference yourPrefrence = YourPreference.getInstance(this);
        setContentView(R.layout.activity_congratulations);
        TextView boo=findViewById(R.id.finale);
        Intent intent=getIntent();
        int chapter=intent.getIntExtra("chapter",0);
        int right=intent.getIntExtra("result",0);
        System.out.println(right);
        System.out.println(chapter);
        chapter++;
        String xd=String.valueOf(chapter);
        if(right>=1)
        {
            System.out.println(yourPrefrence.unlock(xd));
            yourPrefrence.updt(xd,1);
            System.out.println(yourPrefrence.unlock(xd));
        }
        boo.setText("Congrats..."+right+"   "+chapter);
    }
}
