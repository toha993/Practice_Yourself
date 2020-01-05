package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.test1.MainActivity.correct;
import static com.example.test1.MainActivity.word;

public class chapter1clicked extends AppCompatActivity implements View.OnClickListener {
    String txt="means";
    int x=0,p;
    Secondshared secpreference;
    //String eachline;

    TextView thetext,meaning,nthng;
    Button nxt,prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1clicked);
        Intent intent = getIntent();
        secpreference=Secondshared.getInstance(this);
        p=intent.getIntExtra("start",0);
        thetext=findViewById(R.id.textView2);
        meaning=findViewById(R.id.textView);
        nthng=findViewById(R.id.textView3);
        nxt=findViewById(R.id.nxtwrd);
        prev=findViewById(R.id.prev_word);
        nxt.setOnClickListener(this);
        prev.setOnClickListener(this);
        if(secpreference.unlock(Integer.toString(p))==-1)
        {
            x=0;
        }
        else
            x=secpreference.unlock(Integer.toString(p));
        if(p !=0) {
            thetext.setText(word.get(p * 120+x));
            meaning.setText(correct.get(p * 120+x));
        }
        else
        {
            thetext.setText(word.get(x));
            meaning.setText(correct.get(x));
            if(x==0)
                x++;
        }
        nthng.setText(txt);
       // meaning.setText(correct.get(0));
        }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nxtwrd:
                Toast.makeText(this,"Next Word", Toast.LENGTH_SHORT).show();
                if(p*120+x<p*120+120) {
                    x++;
                    secpreference.updt(Integer.toString(p),x);
                    thetext.setText(word.get(p*120+x));
                    meaning.setText(correct.get(p*120+x));
                }
                else
                    openCongratulations();
                break;
            case R.id.prev_word:
                if(p*120+x>(p*120)) {
                    x--;
                    if(p==0 && x==1)
                        x--;
                    secpreference.updt(Integer.toString(p),x);
                    Toast.makeText(this,"Previous Word", Toast.LENGTH_SHORT).show();
                    thetext.setText(word.get(p*120+x));
                    meaning.setText(correct.get(p*120+x));
                }
                else
                {
                    Toast.makeText(this,"No More Previous Word", Toast.LENGTH_SHORT).show();
                   if(p!=0) {
                       secpreference.updt(Integer.toString(p),x);
                       thetext.setText(word.get(p * 120));
                       meaning.setText(correct.get(p * 120));
                   }
                }
                break;

        }
    }
    public void openCongratulations()
    {
        Intent intent =new Intent(this,Congratulations.class);
        startActivity(intent);
    }

}