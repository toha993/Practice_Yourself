package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class activity_review_clicked extends AppCompatActivity implements View.OnClickListener {
    ImageView img,img1,img2,img3;
    YourPreference yourPrefrence;
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_clicked);
        yourPrefrence = YourPreference.getInstance(this);
        btn1= findViewById(R.id.chapter1);
        btn2= findViewById(R.id.chapter2);
        btn3= findViewById(R.id.chapter3);
        btn4= findViewById(R.id.chapter4);
        btn5= findViewById(R.id.chapter5);
       btn6=findViewById(R.id.learn_more);
        img=findViewById(R.id.lock1);
        img1=findViewById(R.id.lock2);
        img2=findViewById(R.id.lock3);
        img3=findViewById(R.id.lock4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        check();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.chapter1:
                Toast.makeText(this,"Clicked Chapter One",Toast.LENGTH_SHORT).show();
                openreviewchapter(0,119);
                break;
            case R.id.chapter2:
                Toast.makeText(this,"Clicked Chapter Two",Toast.LENGTH_SHORT).show();
                openreviewchapter(120,239);
                break;
            case R.id.chapter3:
                    Toast.makeText(this,"Clicked Chapter Three",Toast.LENGTH_SHORT).show();
                    openreviewchapter(240,359);
                    break;
            case R.id.chapter4:
                Toast.makeText(this,"Clicked Chapter Four",Toast.LENGTH_SHORT).show();
                        openreviewchapter(360,479);
                        break;
            case R.id.chapter5:
                Toast.makeText(this,"Clicked Chapter Five",Toast.LENGTH_SHORT).show();
                openreviewchapter(480,599);
                break;
            case R.id.learn_more:
                Toast.makeText(this,"Next Chapters",Toast.LENGTH_SHORT).show();
                openreview2ndclicked();
                break;

        }


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
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
    private void check()
    {
        if(yourPrefrence.unlock(Integer.toString(2)) != 1 )
        {
            btn2.setEnabled(false);
            img.setVisibility(View.VISIBLE);
        }
        else
            img.setVisibility(View.GONE);
        if(yourPrefrence.unlock(Integer.toString(3)) != 1)
        {
            btn3.setEnabled(false);
            img1.setVisibility(View.VISIBLE);
        }
        else
            img1.setVisibility(View.GONE);
        if(yourPrefrence.unlock(Integer.toString(4)) != 1)
        {
            btn4.setEnabled(false);
            img2.setVisibility(View.VISIBLE);
        }
        else
            img2.setVisibility(View.GONE);

        if(yourPrefrence.unlock(Integer.toString(5)) != 1)
        {
            btn5.setEnabled(false);
            img3.setVisibility(View.VISIBLE);
        }
        else
            img3.setVisibility(View.GONE);
    }
}
