package com.example.test1;
import java.util.Locale;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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
    String txt="means",text;
    int x=0,p;
    Secondshared secpreference;
    //String eachline;

    TextView thetext,meaning,nthng;
    TextToSpeech tts;
    Button nxt,prev,shpk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1clicked);
        Intent intent = getIntent();
        secpreference=Secondshared.getInstance(this);
        p=intent.getIntExtra("start",0);
        thetext=findViewById(R.id.textView2);
        shpk=findViewById(R.id.spk);
       // //nmbr=findViewById(R.id.wrdno);
        meaning=findViewById(R.id.textView);
        nthng=findViewById(R.id.textView3);
        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result=tts.setLanguage(Locale.US);
                    if(result==TextToSpeech.LANG_MISSING_DATA ||
                            result==TextToSpeech.LANG_NOT_SUPPORTED){
                    }
                    else{

                    }
                }
            }
        });
        nxt=findViewById(R.id.nxtwrd);
        prev=findViewById(R.id.prev_word);
        nxt.setOnClickListener(this);
        shpk.setOnClickListener(this);
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
            if(p==0 && x==0)
                x++;
            thetext.setText(word.get(x));
            meaning.setText(correct.get(x));
        }
        nthng.setText(txt);
       // meaning.setText(correct.get(0));
        }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nxtwrd:

                if(p*120+x<p*120+120) {
                    Toast.makeText(this,"Next Word", Toast.LENGTH_SHORT).show();
                    x++;
                    if(p==0 && x==1)
                        x++;
                    secpreference.updt(Integer.toString(p),x);
                    thetext.setText(word.get(p*120+x));
                    meaning.setText(correct.get(p*120+x));
                }
                else
                {
                    Toast.makeText(this,"Yahooo...", Toast.LENGTH_SHORT).show();
                    openCongratulations();
                }
                break;
            case R.id.prev_word:
                if(p*120+x==1)
                {
                    Toast.makeText(this,"No More Previous Word", Toast.LENGTH_SHORT).show();
                    secpreference.updt(Integer.toString(p),0);
                    thetext.setText(word.get(0));
                    meaning.setText(correct.get(0));
                }
                else if(p*120+x>(p*120) && (p+x !=1)) {
                    x--;
                    secpreference.updt(Integer.toString(p),x);
                    Toast.makeText(this,"Previous Word", Toast.LENGTH_SHORT).show();
                    thetext.setText(word.get(p*120+x));
                    meaning.setText(correct.get(p*120+x));
                }
                else
                {
                    Toast.makeText(this,"No More Previous Word", Toast.LENGTH_SHORT).show();
                    secpreference.updt(Integer.toString(p),0);
                    thetext.setText(word.get(p * 120));
                    meaning.setText(correct.get(p * 120));
                }
                break;
            case R.id.spk:
                ConvertTextToSpeech();

        }
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub

        if(tts != null){

            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }

    public void openCongratulations()
    {
        Intent intent =new Intent(this,finished.class);
        startActivity(intent);
        finishAffinity();
    }
    private void ConvertTextToSpeech() {
        text = thetext.getText().toString();
        if(text==null||"".equals(text))
        {
            text = "Content not available";
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }else
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

}
