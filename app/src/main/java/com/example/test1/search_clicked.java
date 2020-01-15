package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.icu.lang.UCharacter.toLowerCase;
import static com.example.test1.MainActivity.correct;
import static com.example.test1.MainActivity.word;

public class search_clicked extends AppCompatActivity{
    TextView src,slve,urwrd;
    String words,answer;
    Button sbmt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_clicked);
        src=findViewById(R.id.editText);
        slve=findViewById(R.id.textView7);
        urwrd=findViewById(R.id.yourword);
        urwrd.setText("Input The Word");
        sbmt=findViewById(R.id.submit);
        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                words=src.getText().toString();
                words=words.toLowerCase();
                System.out.println(words);
                int index= Collections.binarySearch(word,words);
                System.out.println(index);
                if(index <= -1)
                {
                    answer="Sorry.No Word Is Found!";
                }
                else
                {
                    answer="Meaning is "+correct.get(index);
                    answer=answer.toUpperCase();
                }
                slve.setText(answer);
            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finishAffinity();

    }
}
