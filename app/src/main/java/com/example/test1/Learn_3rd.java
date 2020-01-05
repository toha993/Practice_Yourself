package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Learn_3rd extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_3rd);
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

}
