package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.icu.lang.UCharacter.toLowerCase;
import static android.widget.Toast.*;
import static android.widget.Toast.LENGTH_SHORT;
import static com.example.test1.MainActivity.correct;
import static com.example.test1.MainActivity.dictmean;
import static com.example.test1.MainActivity.dictword;
import static com.example.test1.MainActivity.word;


public class search_clicked extends AppCompatActivity implements View.OnClickListener{
    TextView src,slve,urwrd;
    String words,answer;
    static int done=0;
    Button sbmt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search_clicked);
        LottieAnimationView lot=findViewById(R.id.animation_view);
        lot.setOnClickListener(this);
        src=findViewById(R.id.editText);
        urwrd=findViewById(R.id.textView4);
        slve=findViewById(R.id.textView7);
        if(done==0) {
            try {
                InputStream inputStream = getResources().openRawResource(R.raw.dict);
                BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream));
                String thisLine;
                while ((thisLine = buff.readLine()) != null) {
                    // System.out.println(thisLine);
                    String[] values = thisLine.split("#");
                    dictword.add(values[0]);
                    dictmean.add(values[1]);
                }
                buff.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            done=1;
        }
        //System.out.println(dictword.size());
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finishAffinity();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.animation_view) {
            words = src.getText().toString().trim();
            src.onEditorAction(EditorInfo.IME_ACTION_DONE);
            words = words.toLowerCase();
            int index = Collections.binarySearch(dictword, words);
            if (index <= -1) {
                answer = "Sorry.No Word Is Found!";
            } else {
                answer = dictmean.get(index);
                //answer=answer.toUpperCase();
            }
            slve.setText(answer);
            urwrd.setText(words+":");
            src.setText("");
        }
    }
}
