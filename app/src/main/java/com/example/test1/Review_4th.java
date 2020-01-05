package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Review_4th extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_4th);
        Button btn1= findViewById(R.id.chapter16);
        Button btn2= findViewById(R.id.chapter17);
        Button btn3= findViewById(R.id.chapter18);
        Button btn4= findViewById(R.id.chapter19);
        Button btn5= findViewById(R.id.chapter20);
        Button btn6=findViewById(R.id.prev2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.chapter16:
                Toast.makeText(this,"Clicked Chapter Sixteen",Toast.LENGTH_SHORT).show();
                openreviewchapter(1800,1919);
                break;
            case R.id.chapter17:
                Toast.makeText(this,"Clicked Chapter Seventeen",Toast.LENGTH_SHORT).show();
                openreviewchapter(1920,2039);
                break;
            case R.id.chapter18:
                Toast.makeText(this,"Clicked Chapter Eighteen",Toast.LENGTH_SHORT).show();
                openreviewchapter(2040,2159);
                break;
            case R.id.chapter19:
                Toast.makeText(this,"Clicked Chapter Nineteen",Toast.LENGTH_SHORT).show();
                openreviewchapter(2160,2279);
                break;
            case R.id.chapter20:
                Toast.makeText(this,"Clicked Chapter Twenty",Toast.LENGTH_SHORT).show();
                openreviewchapter(2280,2400);
                break;
            case R.id.prev:
                Toast.makeText(this,"Previous Chapters",Toast.LENGTH_SHORT).show();
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
    public void openreview3rdclicked()
    {
        Intent intent =new Intent(this,Review_3rd.class);
        startActivity(intent);
        //finishAffinity();
    }
}
