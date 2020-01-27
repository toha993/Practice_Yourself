package com.example.test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    CardView lrn, rvw, src;
    TextView txt1, txt2, txt3,shw;
    static int xp=0;
    //Arrays.fill(chapters,Boolean.FALSE);
    public static boolean[] chapters = new boolean[30];
    public static List<String> word = new ArrayList<>();
    public static List<String> correct = new ArrayList<>();
    public static List<String> op1 = new ArrayList<>();
    public static List<String> op2 = new ArrayList<>();
    public static List<String> op3 = new ArrayList<>();
    public static List<String> op4 = new ArrayList<>();
    public static List<String> chapter = new ArrayList<>();
    public static List<String> dictword = new ArrayList<>();
    public static List<String> dictmean = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        if(xp==0) {
            InputStream fr = getResources().openRawResource(R.raw.words);
            Scanner inFile = new Scanner(fr);
            // int ck=0;
            while (inFile.hasNext()) {
                String line = inFile.nextLine();
                String[] values = line.split(",");
                word.add(values[0]);
                correct.add(values[1]);
                op1.add(values[2]);
                op2.add(values[3]);
                op3.add(values[4]);
                op4.add(values[5]);
                chapter.add(values[6]);
            }
            inFile.close();
            xp=1;
        }
            lrn = findViewById(R.id.crd1);
            rvw = findViewById(R.id.crd2);
            src = findViewById(R.id.crd3);
            txt1 = findViewById(R.id.learnn);
            txt2 = findViewById(R.id.revieww);
            txt3 = findViewById(R.id.searchh);
            shw = findViewById(R.id.ttl);
            shw.setText("Prepare Yourself");
            txt1.setText("Learn");
            txt2.setText("Review");
            txt3.setText("Search");
            lrn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openlearnclicked();
                }
            });
            rvw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openreviewclicked();
                }
            });
            src.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opensearch();
                }
            });

        }
        @Override
        public void onBackPressed () {
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            MainActivity.super.onBackPressed();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
        public void openlearnclicked ()
        {
            Intent intent = new Intent(this, learn_clicked.class);
            startActivity(intent);
        }
        public void openreviewclicked ()
        {
            Intent intent = new Intent(this, activity_review_clicked.class);
            startActivity(intent);
        }
        public void opensearch ()
        {

            Intent intent = new Intent(this, search_clicked.class);
            startActivity(intent);
        }


    }