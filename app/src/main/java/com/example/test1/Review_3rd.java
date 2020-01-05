package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Review_3rd extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_3rd);
        Button btn1= findViewById(R.id.chapter11);
        Button btn2= findViewById(R.id.chapter12);
        Button btn3= findViewById(R.id.chapter13);
        Button btn4= findViewById(R.id.chapter14);
        Button btn5= findViewById(R.id.chapter15);
        Button btn6 = findViewById(R.id.prev1);
        Button btn7=findViewById(R.id.learn_more2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.chapter1:
                Toast.makeText(this,"Clicked Chapter One",Toast.LENGTH_SHORT).show();
                openreviewchapter(1200,1319);
                break;
            case R.id.chapter2:
                Toast.makeText(this,"Clicked Chapter Two",Toast.LENGTH_SHORT).show();
                openreviewchapter(1320,1439);
                break;
            case R.id.chapter3:
                Toast.makeText(this,"Clicked Chapter Three",Toast.LENGTH_SHORT).show();
                openreviewchapter(1440,1559);
                break;
            case R.id.chapter4:
                Toast.makeText(this,"Clicked Chapter Four",Toast.LENGTH_SHORT).show();
                openreviewchapter(1560,1679);
                break;
            case R.id.chapter5:
                Toast.makeText(this,"Clicked Chapter Five",Toast.LENGTH_SHORT).show();
                openreviewchapter(1680,1799);
                break;
            case R.id.prev1:
                Toast.makeText(this,"Previous Chapters",Toast.LENGTH_SHORT).show();
                openreview2ndclicked();
                break;
            case R.id.learn_more2:
                Toast.makeText(this,"Next Chapters",Toast.LENGTH_SHORT).show();
                openreview4thclicked();
                break;
        }
    }
    private void openreviewchapter(int start,int end)
    {
        Intent intent=new Intent(this,Review_chapter.class);
        intent.putExtra("start",start);
        intent.putExtra("end",end);
        startActivity(intent);

    }
    public void openreview2ndclicked()
    {
        Intent intent =new Intent(this,Review_2nd.class);
        startActivity(intent);
        //finishAffinity();
    }
    public void openreview4thclicked()
    {
        Intent intent =new Intent(this,Review_4th.class);
        startActivity(intent);
        //finishAffinity();
    }
}
