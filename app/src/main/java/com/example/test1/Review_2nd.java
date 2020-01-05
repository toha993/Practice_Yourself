package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Review_2nd extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_2nd2);
        Button btn1= findViewById(R.id.chapter6);
        Button btn2= findViewById(R.id.chapter7);
        Button btn3= findViewById(R.id.chapter8);
        Button btn4= findViewById(R.id.chapter9);
        Button btn5= findViewById(R.id.chapter10);
        Button btn6 = findViewById(R.id.prev);
        Button btn7=findViewById(R.id.learn_more1);

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
            case R.id.chapter6:
                Toast.makeText(this,"Clicked Chapter One",Toast.LENGTH_SHORT).show();
                openreviewchapter(600,719);
                break;
            case R.id.chapter7:
                Toast.makeText(this,"Clicked Chapter Two",Toast.LENGTH_SHORT).show();
                openreviewchapter(720,839);
                break;
            case R.id.chapter8:
                Toast.makeText(this,"Clicked Chapter Three",Toast.LENGTH_SHORT).show();
                openreviewchapter(840,959);
                break;
            case R.id.chapter9:
                Toast.makeText(this,"Clicked Chapter Four",Toast.LENGTH_SHORT).show();
                openreviewchapter(960,1079);
                break;
            case R.id.chapter10:
                Toast.makeText(this,"Clicked Chapter Five",Toast.LENGTH_SHORT).show();
                openreviewchapter(1080,1199);
                break;
            case R.id.prev:
                Toast.makeText(this,"Previous Chapters",Toast.LENGTH_SHORT).show();
                openreviewclicked();
                break;
            case R.id.learn_more1:
                Toast.makeText(this,"Next Chapters",Toast.LENGTH_SHORT).show();
                openreview3rdclicked();
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
    public void openreviewclicked()
    {
        Intent intent =new Intent(this,activity_review_clicked.class);
        startActivity(intent);
       // finishAffinity();
    }
    public void openreview3rdclicked()
    {
        Intent intent =new Intent(this,Review_3rd.class);
        startActivity(intent);
       // finishAffinity();
    }
}
