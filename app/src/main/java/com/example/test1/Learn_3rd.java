package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Learn_3rd extends AppCompatActivity implements View.OnClickListener{
    ImageView img,img1,img2,img3,img4;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    YourPreference yourPrefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_learn_3rd);
        btn1= findViewById(R.id.chapter11);
        btn2= findViewById(R.id.chapter12);
        btn3= findViewById(R.id.chapter13);
        btn4= findViewById(R.id.chapter14);
        btn5= findViewById(R.id.chapter15);
        btn6 = findViewById(R.id.prev1);
        btn7=findViewById(R.id.learn_more2);
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
        switch (view.getId())
        {
            case R.id.chapter11:
                Toast.makeText(this,"Clicked Chapter Eleven",Toast.LENGTH_SHORT).show();
                openchapter1clicked(10);
                // openlearnclicked();
                break;
            case R.id.chapter12:
                Toast.makeText(this,"Clicked Chapter Twelve",Toast.LENGTH_SHORT).show();
                openchapter1clicked(11);
                break;
            case R.id.chapter13:
                Toast.makeText(this,"Clicked Chapter Thirteen",Toast.LENGTH_SHORT).show();
                openchapter1clicked(12);
                break;
            case R.id.chapter14:
                Toast.makeText(this,"Clicked Chapter Fourteen",Toast.LENGTH_SHORT).show();
                openchapter1clicked(13);
                break;
            case R.id.chapter15:
                Toast.makeText(this,"Clicked Chapter Fifteen",Toast.LENGTH_SHORT).show();
                openchapter1clicked(14);
                break;
            case R.id.prev1:
                Toast.makeText(this,"Previous Chapters",Toast.LENGTH_SHORT).show();
                openlearnclicked();
                break;
            case R.id.learn_more2:
                Toast.makeText(this,"Next Chapters",Toast.LENGTH_SHORT).show();
                openlearn4thclicked();
                break;
        }
    }
    private void openchapter1clicked(int x) {
        Intent intent =new Intent(this,chapter1clicked.class);
        intent.putExtra("start",x);
        startActivity(intent);
    }
    public void openlearnclicked()
    {
        Intent intent =new Intent(this,Learn_2nd.class);
        startActivity(intent);
        finishAffinity();
    }
    public void openlearn4thclicked()
    {
        Intent intent =new Intent(this,Learn_4th.class);
        startActivity(intent);
        finishAffinity();
    }
    private void check()
    {
        if(yourPrefrence.unlock(Integer.toString(11)) != 1 )
        {
            btn1.setEnabled(false);
            img4.setVisibility(View.VISIBLE);
        }
        else
            img4.setVisibility(View.GONE);
        if(yourPrefrence.unlock(Integer.toString(12)) != 1 )
        {
            btn2.setEnabled(false);
            img.setVisibility(View.VISIBLE);
        }
        else
            img.setVisibility(View.GONE);
        if(yourPrefrence.unlock(Integer.toString(13)) != 1)
        {
            btn3.setEnabled(false);
            img1.setVisibility(View.VISIBLE);
        }
        else
            img1.setVisibility(View.GONE);
        if(yourPrefrence.unlock(Integer.toString(14)) != 1)
        {
            btn4.setEnabled(false);
            img2.setVisibility(View.VISIBLE);
        }
        else
            img2.setVisibility(View.GONE);

        if(yourPrefrence.unlock(Integer.toString(15)) != 1)
        {
            btn5.setEnabled(false);
            img3.setVisibility(View.VISIBLE);
        }
        else
            img3.setVisibility(View.GONE);
    }

}
