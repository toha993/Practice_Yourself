package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.view.View.GONE;

public class Review_2nd extends AppCompatActivity implements View.OnClickListener{
    ImageView img,img1,img2,img3,img4;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    YourPreference yourPrefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_2nd2);
         btn1= findViewById(R.id.chapter6);
         btn2= findViewById(R.id.chapter7);
         btn3= findViewById(R.id.chapter8);
         btn4= findViewById(R.id.chapter9);
         btn5= findViewById(R.id.chapter10);
         btn6 = findViewById(R.id.prev);
         btn7=findViewById(R.id.learn_more1);
        yourPrefrence = YourPreference.getInstance(this);
        img=findViewById(R.id.lock1);
        img1=findViewById(R.id.lock2);
        img2=findViewById(R.id.lock3);
        img3=findViewById(R.id.lock4);
        img4=findViewById(R.id.lock);
        check();
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
    private void check()
    {
        if(yourPrefrence.unlock(Integer.toString(6)) != 1 )
        {
            btn1.setEnabled(false);
            img4.setVisibility(View.VISIBLE);
        }
        else
            img4.setVisibility(View.GONE);
        if(yourPrefrence.unlock(Integer.toString(7)) != 1 )
        {
            btn2.setEnabled(false);
            img.setVisibility(View.VISIBLE);
        }
        else
            img.setVisibility(GONE);
        if(yourPrefrence.unlock(Integer.toString(8)) != 1)
        {
            btn3.setEnabled(false);
            img1.setVisibility(View.VISIBLE);
        }
        else
            img1.setVisibility(GONE);
        if(yourPrefrence.unlock(Integer.toString(9)) != 1)
        {
            btn4.setEnabled(false);
            img2.setVisibility(View.VISIBLE);
        }
        else
            img2.setVisibility(GONE);

        if(yourPrefrence.unlock(Integer.toString(10)) != 1)
        {
            btn5.setEnabled(false);
            img3.setVisibility(View.VISIBLE);
        }
        else
            img3.setVisibility(GONE);
    }
}
